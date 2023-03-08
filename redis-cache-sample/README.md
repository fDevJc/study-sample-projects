### 부하테스트 도구 k6
- 선정이유
  - 간단하게 CLI명령으로 테스트가능
  - javaScript기반으로 쓰기 편함
  - 큰 설정 없이 간단하게 쓰기 편하다고 생각
  - Docker로 설치가능
---
## 실습
### 환경
- Docker MySQL
- Docker Redis
- Docker k6
### 목표
- Redis cache를 적용하여 DB 성능 향상

### 순서
1. 설치 & 세팅
```shell
# mysql image pull
docker pull mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql mysql
docker exec -it mysql /bin/bash
mysql -u root -p
CREATE DATABASE redis_sample;

# redis image pull
docker pull redis
docker run -d -p 6379:6379 --name redis redis
# redis cli 접속
docker exec -it redis redis-cli

# k6 image pull
# docker pull grafana/k6
# m1 칩 호환성 문제로 맥에 k6 바로 설치
brew install k6
```
2. 예제 애플리케이션 작성
- PostController, PostService, PostRepository, Post
- 조회, 작성 API
3. k6 스크립트 작성
- load.js, stress.js 작성
4. 기본 설정 부하테스트
5. 페이징 처리 후 부하테스트
- DefaultPagable 사용하여 테스트
6. 레디스 적용 후 부하테스트

## 결론
[k6결과정리](https://github.com/fDevJc/study-sample-projects/blob/master/redis-cache-sample/k6-result/result-67577.md)
- 복잡한 비즈니스 로직이 없는 단순 조회 예제라서 당연한 결과이지만 조회성능이 엄청나게 좋아짐
- 실무에서 캐시를 적용할땐 해당 데이터의 변화여부가 중요하기때문에 어디에 캐시를 적용할지 고민 해봐야함

## 과제
- redis 서버가 내려갈경우 cache 적용의 문제가 아니라 조회가 안되는 문제
  - RedisTemplate를 사용하는 CacheService를 생성해서 처리하면 될거같은데 애노테이션 사용하고 못하나
  - 공부를 좀더 해야겠다...