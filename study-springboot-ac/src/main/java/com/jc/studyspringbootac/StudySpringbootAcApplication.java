package com.jc.studyspringbootac;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudySpringbootAcApplication {
	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args -> System.out.println(report.getConditionAndOutcomesBySource()
			.entrySet()
			.stream()
			.filter(con -> con.getValue().isFullMatch())
			.peek(con -> {
				System.out.println(con.getKey());
				con.getValue().forEach(c -> System.out.println("\t" + c.getOutcome()));
				System.out.println();
			}).count());
	}

	public static void main(String[] args) {
		SpringApplication.run(StudySpringbootAcApplication.class, args);
	}

}
