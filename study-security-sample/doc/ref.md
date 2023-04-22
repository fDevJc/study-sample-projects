# Overview
## Spring Security
- 스프링 시큐리티는 인증, 인가 그리고 여러 공격에 대한 보호를 제공해주는 프레임워크

## Spring Boot Auto Configuration
- `springSecurityFilterChain`라고 불리는 서블릿 필터를 생성하여 기본적 설정을 활성화
- 해당 빈은 애플리케이션의 모든 시큐리티에 관한 책임이 있다
- `UserDetailsService` 빈은 유저네임과 임의의 비밀번호를 가지고 생성된다
- 