# 스프링과 자바의 학습을 위한 저장소
## 스프링
- @Conditional, Conditional 인터페이스를 활용하여 Bean 자동생성을 선택적으로
- @ConfigurationProperties
  - properties, yml 파일을 읽어와서 사용
- @Async
  - 비동기 프로그래밍을 위해사용(main thread가 아닌 sub thread)
  - 사용방법
    - ThreadPoolTaskExecutor Bean으로 등록
    - @EnableAsync 설정
    - 비동기 처리할 메소드에 @Async("beanName") 설정
  - 주의사항
    - Proxy로 처리되기 때문에 @Async 메소드를 가진 클래스가 빈으로 등록되어야함
    - Proxy로 처리되기 때문에 내부에서 호출할경우 비동기 처리 X
## 스프링부트

## 자바