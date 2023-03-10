# 스프링과 자바의 학습을 위한 저장소
## 스프링
- @Conditional
  - Conditional 인터페이스를 활용하여 Bean 자동생성을 선택적으로
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
- 비동기
  - ExecutorService : 비동기 작업 실행을 도와주는 인터페이스
  - Future : 비동기 작업의 결과를 받을 수 있는 인터페이스
  - FutureTask : Future의 경우 생성,실행이 동시에 FutureTask의 경우 생성,실행 분리
  - CompletableFuture : Future의 한계점 해소를 위해 등장
    - 작업 중첩, 콜백작업, 예외처리