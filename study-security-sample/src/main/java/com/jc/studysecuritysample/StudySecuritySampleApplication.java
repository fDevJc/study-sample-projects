package com.jc.studysecuritysample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudySecuritySampleApplication {
	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args ->
			System.out.println("total count :: " +
				report.getConditionAndOutcomesBySource()
					.entrySet()
					.stream()
					.filter(e -> e.getValue().isFullMatch())
					.peek(entry -> {
						System.out.println("AutoConfiguration :: " + entry.getKey());
						entry.getValue().forEach(
							con -> System.out.println("\t" + con.getOutcome())
						);
						System.out.println();
					}).count()
			);
	}

	public static void main(String[] args) {
		SpringApplication.run(StudySecuritySampleApplication.class, args);
	}

}
