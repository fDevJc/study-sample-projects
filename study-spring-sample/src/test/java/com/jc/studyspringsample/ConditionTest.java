package com.jc.studyspringsample;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionTest {
	@Test
	void getBean() throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SomethingConfig.class);
		applicationContext.refresh();

		Something bean = applicationContext.getBean(Something.class);
		assertThat(bean).isInstanceOf(Something.class);
	}

	@Test
	void noConditionException() throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SomethingConfig.class, CustomSomethingClass.class);
		applicationContext.refresh();

		assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(Something.class));
	}
	
	@Test
	void applyCondition() throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ConditionConfig.class, CustomConditionConfig.class);
		applicationContext.refresh();

		Something bean = applicationContext.getBean(Something.class);
		assertThat(bean).isInstanceOf(Something.class);
	}

	@Configuration
	@MyConditional(true)
	static class ConditionConfig {
		@Bean
		Something something() {
			return new SomethingClass();
		}
	}

	@Configuration
	@MyConditional(false)
	static class CustomConditionConfig {
		@Bean
		Something something() {
			return new CustomSomethingClass();
		}
	}
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(MyCondition.class)
	@interface MyConditional {
		boolean value();
	}


	static class MyCondition implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			Map<String, Object> myConditional = metadata.getAnnotationAttributes(MyConditional.class.getName());
			return (boolean)myConditional.get("value");
		}
	}


	@Configuration
	static class SomethingConfig {
		@Bean
		Something something() {
			return new SomethingClass();
		}
	}

	@Configuration
	static class CustomSomethingConfig {
		@Bean
		Something something() {
			return new CustomSomethingClass();
		}
	}

	interface Something {
	}

	static class SomethingClass implements Something {
	}

	static class CustomSomethingClass implements Something {
	}

}
