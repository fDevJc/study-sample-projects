# @EnableWebMvc 을 선언하면 어떻게 될까?

### 스프링부트의 기본 AutoConfiguration 사용 
```java
@AutoConfiguration(after = { DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
ValidationAutoConfiguration.class })
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class WebMvcAutoConfiguration {}
```

### @EnableWebMvc 구현할 경우
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(DelegatingWebMvcConfiguration.class)
public @interface EnableWebMvc {
}
```
### DelegatingWebMvcConfiguration.class
```java
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {}
```

### 결론
`WebMvcAutoConfiguration`의 애노테이션 중 `ConditionalOnMissingBean`을 보면 
`WebMvcConfigurationSupport`의 빈이 존재하지 않을때 해당 설정파일이 빈으로 등록된다

하지만 `@EnableWebMvc`를 구현할 경우 `@Import`를 통해 `WebMvcConfigurationSupport`를 상속받은 
`DelegatingWebMvcConfiguration`이 등록된다 