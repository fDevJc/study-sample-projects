# Spring Security 공부

## AutoConfiguration
### SecurityAutoConfiguration
```shell
@Import({ SpringBootWebSecurityConfiguration.class, SecurityDataConfiguration.class })
public class SecurityAutoConfiguration {
  @Bean
  @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
  public DefaultAuthenticationEventPublisher authenticationEventPublisher(ApplicationEventPublisher publisher){}
}
```
- SpringBootWebSecurityConfiguration 임포트
  - 실제 웹 시큐리티관련 설정들이 있을듯?
- SecurityDataConfiguration 임포트
  - 시큐리티와 관련된 데이터 설정 ?
- DefaultAuthenticationEventPublisher 빈생성
  - 인증관련 이벤트 퍼블리셔가 없다면 디폴트 이벤트 퍼블리셔를 생성해서 빈생성

### SpringBootWebSecurityConfiguration
```shell
class SpringBootWebSecurityConfiguration {
  	
  	@Configuration(proxyBeanMethods = false)
	@ConditionalOnDefaultWebSecurity
	static class SecurityFilterChainConfiguration {
		@Bean
		@Order(SecurityProperties.BASIC_AUTH_ORDER)
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {}
	}
	
	@Configuration(proxyBeanMethods = false)
	@ConditionalOnClass(WebInvocationPrivilegeEvaluator.class)
	@ConditionalOnBean(WebInvocationPrivilegeEvaluator.class)
	static class ErrorPageSecurityFilterConfiguration {
		@Bean
		FilterRegistrationBean<ErrorPageSecurityFilter> errorPageSecurityFilter(ApplicationContext context) {}
	}
	
	@Configuration(proxyBeanMethods = false)
	@ConditionalOnMissingBean(name = BeanIds.SPRING_SECURITY_FILTER_CHAIN)
	@ConditionalOnClass(EnableWebSecurity.class)
	@EnableWebSecurity
	static class WebSecurityEnablerConfiguration {}
}
```
- SecurityFilterChainConfiguration
  - SecurityFilterChain 빈 생성
- ErrorPageSecurityFilterConfiguration
  - FilterRegistrationBean<ErrorPageSecurityFilter> 빈 생성
  - 서블릿 3.0+ 컨테이너 필터를 등록하기 위한 ServletContextInitializer.
- WebSecurityEnablerConfiguration
  - @EnableWebSecurity

### SecurityDataConfiguration
- 이친구는 뭔가 Security를 확장해주는 녀석 ?

### @EnableWebSecurity
```shell
@Import({ WebSecurityConfiguration.class, SpringWebMvcImportSelector.class, OAuth2ImportSelector.class,
		HttpSecurityConfiguration.class })
@EnableGlobalAuthentication
@Configuration
public @interface EnableWebSecurity {}
```

### WebSecurityConfiguration
```shell

```
- 웹시큐리티를 이용하여 필터체인 프록시를 생성한다
- WebSecurityConfigurer를 구현하거나 WebSecurityCustomizer 빈을 노출하여 커스터마이징 가능
- EnableWebSecurity를 사용할때 가져옴
- 빈생성
  - public static DelegatingApplicationListener delegatingApplicationListener() {}
  - public SecurityExpressionHandler<FilterInvocation> webSecurityExpressionHandler() {}
  - @Bean(name = AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) <br>
     public Filter springSecurityFilterChain() throws Exception {}
      - 필터체인 만들어주는 녀석 ?
  - public WebInvocationPrivilegeEvaluator privilegeEvaluator() {}
- 그외 여러 세터 메서드들이 존재하네

### SpringWebMvcImportSelector
- DispatcherServlet 이 존재하면 WebMvcSecurityConfiguration 로드 

### OAuth2ImportSelector
- OAuth 관련 조건에따라 여러 임포트 셀렉터
  - OAuth2ClientConfiguration 요런거

### HttpSecurityConfiguration
- HttpSecurity httpSecurity() throws Exception {}
  - 자주본게 있네 여기서 디폴트값을 지정해주네

### @EnableGlobalAuthentication
```shell
@Import(AuthenticationConfiguration.class)
@Configuration
public @interface EnableGlobalAuthentication {}
```

### AuthenticationConfiguration