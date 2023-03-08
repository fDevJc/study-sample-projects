package com.jc.rediscachesample.config;

import static org.springframework.data.redis.cache.RedisCacheManager.*;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableCaching
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

		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());

		return redisTemplate;
	}

	/*
		CacheManager
		스프링에서 기본적으로 지원하는 캐시저장소는 ConcurrentHashMap
		그외 캐시저장소를 이용하기위해서는 캐시매니저를 Bean으로 등록
		- EhCacheCacheManager, CaffeineCacheManager, RedisCacheManager 등등
	 */
	@Bean
	public CacheManager redisCacheManager() {
		return RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory())
			.cacheDefaults(redisCacheConfiguration())
			.build();
	}

	private RedisCacheConfiguration redisCacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
			.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
			.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
			// .entryTtl(Duration.ofSeconds(10L));	//test를 위해 10초의 TTL
			.entryTtl(Duration.ofHours(1L));
	}
}
