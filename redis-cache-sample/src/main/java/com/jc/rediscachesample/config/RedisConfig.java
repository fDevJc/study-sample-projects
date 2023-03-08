package com.jc.rediscachesample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private int redisPort;

	/*
		Lettuce
		Multi-Thread 에서 Thread-Safe한 Redis 클라이언트로 netty에 의해 관리
		비동기 방식으로 요청하기에 Jedis보다 성능이 뛰어나다
		스프링 부트의 기본 의존성은 현재 Lettuce

		Jedis
		Multi-Thread 에서 Thread-unsafe, Connection pool을 이용해 멀티쓰레드 환경을 구성
		Jedis 인스턴스와 연결할 때마다 Connection pool을 불러오고 스레드 수가 늘어나면 시간이 상당히 소요될 수 있다.
	 */
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(redisHost, redisPort);
	}

	/*
		RedisTemplate
		redis data access 코드를 간소화 하기 위해 제공되는 클래스
		주어진 객체들을 자동으로 직렬화, 역직렬화 하며 binary 데이터를 redis에 저장

		StringRedisSerializer: String 직렬화/역직렬화 (UTF-8)
		GenericJackson2JsonRedisSerializer: 객체를 json타입으로 직렬화/역직렬화
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		// redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());

		return redisTemplate;
	}
}
