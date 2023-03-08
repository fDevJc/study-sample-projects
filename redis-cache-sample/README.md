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
docker pull redis:alpine

# k6 image pull
#docker pull grafana/k6
# m1 칩 호환성 문제로 맥에 k6 바로 설치
brew install k6
```

2. 예제 애플리케이션 작성
- PostController, PostService, PostRepository, Post
- 조회, 작성 API

3. k6 스크립트 작성
- 