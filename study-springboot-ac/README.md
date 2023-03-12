# 스프링부트의 자동구성 관련 공부레포

## -Ddebug
- 애플리케이션을 실행하면 CONDITIONS EVALUATION REPORT 확인가능
```shell
   AopAutoConfiguration matched:
      - @ConditionalOnProperty (spring.aop.auto=true) matched (OnPropertyCondition)

   AopAutoConfiguration.ClassProxyingConfiguration matched:
      - @ConditionalOnMissingClass did not find unwanted class 'org.aspectj.weaver.Advice' (OnClassCondition)
      - @ConditionalOnProperty (spring.aop.proxy-target-class=true) matched (OnPropertyCondition)

   GenericCacheConfiguration matched:
      - Cache org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration automatic cache type (CacheCondition)
   ...
```

## ConditionEvaluationReport 빈을 이용 필요한 정보만
```shell
	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args -> {
			System.out.println(report.getConditionAndOutcomesBySource()
				.entrySet()
				.stream()
				.filter(con -> con.getValue().isFullMatch())
				.map(con -> {
					System.out.println(con.getKey());
					con.getValue().forEach(c -> {
						System.out.println("\t" + c.getOutcome());
					});
					System.out.println();
					return con;
				}).count());
		};
	}
```
## 주요 프레임워크 자동구성 공부
- [Spring-Security](/docs/spring-secutiry-ac.md)