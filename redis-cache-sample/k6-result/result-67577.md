## 환경
- 전체 데이터 수 : 67577
- 전체 데이터 조회
---
### 페이징 처리 전
```shell
  execution: local
     script: load.js
     output: -

  scenarios: (100.00%) 1 scenario, 100 max VUs, 55s max duration (incl. graceful stop):
           * default: Up to 100 looping VUs for 25s over 5 stages (gracefulRampDown: 30s, gracefulStop: 30s)


     data_received..................: 1.4 GB 49 MB/s
     data_sent......................: 27 kB  896 B/s
     http_req_blocked...............: avg=154.65µs min=1µs      med=6µs     max=1.69ms   p(90)=436.7µs  p(95)=503.69µs
     http_req_connecting............: avg=105.27µs min=0s       med=0s      max=1.46ms   p(90)=316µs    p(95)=354.69µs
   ✗ http_req_duration..............: avg=4.9s     min=163.57ms med=4.5s    max=14.53s   p(90)=10.01s   p(95)=10.21s
       { expected_response:true }...: avg=4.9s     min=163.57ms med=4.5s    max=14.53s   p(90)=10.01s   p(95)=10.21s
     http_req_failed................: 0.00%  ✓ 0         ✗ 314
     http_req_receiving.............: avg=87.54ms  min=20.67ms  med=51.73ms max=378.64ms p(90)=209.71ms p(95)=264.68ms
     http_req_sending...............: avg=54.67µs  min=8µs      med=31µs    max=1.19ms   p(90)=84.7µs   p(95)=117.69µs
     http_req_tls_handshaking.......: avg=0s       min=0s       med=0s      max=0s       p(90)=0s       p(95)=0s
     http_req_waiting...............: avg=4.81s    min=133.15ms med=4.45s   max=14.31s   p(90)=9.96s    p(95)=10.12s
     http_reqs......................: 314    10.544913/s
     iteration_duration.............: avg=4.9s     min=163.71ms med=4.5s    max=14.53s   p(90)=10.01s   p(95)=10.21s
     iterations.....................: 314    10.544913/s
     vus............................: 12     min=1       max=100
     vus_max........................: 100    min=100     max=100


running (29.8s), 000/100 VUs, 314 complete and 0 interrupted iterations
default ✓ [======================================] 000/100 VUs  25s
ERRO[0030] thresholds on metrics 'http_req_duration' have been breached
```
```shell
  execution: local
     script: stress.js
     output: -

  scenarios: (100.00%) 1 scenario, 400 max VUs, 1m25s max duration (incl. graceful stop):
           * default: Up to 400 looping VUs for 55s over 7 stages (gracefulRampDown: 30s, gracefulStop: 30s)


     data_received..................: 2.9 GB 34 MB/s
     data_sent......................: 68 kB  799 B/s
     http_req_blocked...............: avg=312.6µs  min=1µs      med=307µs   max=6.9ms    p(90)=616.8µs  p(95)=1.09ms
     http_req_connecting............: avg=196.19µs min=0s       med=227µs   max=2.32ms   p(90)=377.4µs  p(95)=506.19µs
   ✗ http_req_duration..............: avg=24.44s   min=736.48ms med=23.31s  max=52.15s   p(90)=46.13s   p(95)=46.65s
       { expected_response:true }...: avg=24.1s    min=736.48ms med=22.77s  max=47.26s   p(90)=46.13s   p(95)=46.62s
     http_req_failed................: 3.24%  ✓ 21       ✗ 626
     http_req_receiving.............: avg=141.28ms min=208µs    med=92.58ms max=671.47ms p(90)=321.93ms p(95)=378.05ms
     http_req_sending...............: avg=97.68µs  min=4µs      med=55µs    max=3.67ms   p(90)=130.4µs  p(95)=264.19µs
     http_req_tls_handshaking.......: avg=0s       min=0s       med=0s      max=0s       p(90)=0s       p(95)=0s
     http_req_waiting...............: avg=24.3s    min=674.79ms med=23.05s  max=52.15s   p(90)=46.01s   p(95)=46.47s
     http_reqs......................: 647    7.608823/s
     iteration_duration.............: avg=24.44s   min=737.39ms med=23.31s  max=52.15s   p(90)=46.14s   p(95)=46.66s
     iterations.....................: 647    7.608823/s
     vus............................: 9      min=9      max=400
     vus_max........................: 400    min=400    max=400


running (1m25.0s), 000/400 VUs, 647 complete and 152 interrupted iterations
default ✓ [======================================] 008/400 VUs  55s
ERRO[0085] thresholds on metrics 'http_req_duration' have been breached

```
### 페이징 처리 후
```shell
  execution: local
     script: load.js
     output: -

  scenarios: (100.00%) 1 scenario, 100 max VUs, 55s max duration (incl. graceful stop):
           * default: Up to 100 looping VUs for 25s over 5 stages (gracefulRampDown: 30s, gracefulStop: 30s)


     data_received..................: 2.7 MB 106 kB/s
     data_sent......................: 308 kB 12 kB/s
     http_req_blocked...............: avg=14.15µs  min=1µs    med=4µs      max=1.06ms p(90)=5µs      p(95)=12µs
     http_req_connecting............: avg=7.81µs   min=0s     med=0s       max=609µs  p(90)=0s       p(95)=0s
   ✓ http_req_duration..............: avg=288.46ms min=4.54ms med=249.71ms max=1.84s  p(90)=653.18ms p(95)=686.04ms
       { expected_response:true }...: avg=288.46ms min=4.54ms med=249.71ms max=1.84s  p(90)=653.18ms p(95)=686.04ms
     http_req_failed................: 0.00%  ✓ 0          ✗ 3625
     http_req_receiving.............: avg=136.18µs min=23µs   med=115µs    max=5.68ms p(90)=200µs    p(95)=266µs
     http_req_sending...............: avg=18.9µs   min=3µs    med=17µs     max=576µs  p(90)=23µs     p(95)=35µs
     http_req_tls_handshaking.......: avg=0s       min=0s     med=0s       max=0s     p(90)=0s       p(95)=0s
     http_req_waiting...............: avg=288.31ms min=4.45ms med=249.58ms max=1.84s  p(90)=653.05ms p(95)=685.91ms
     http_reqs......................: 3625   144.995604/s
     iteration_duration.............: avg=288.59ms min=4.62ms med=249.78ms max=1.84s  p(90)=653.34ms p(95)=686.17ms
     iterations.....................: 3625   144.995604/s
     vus............................: 1      min=1        max=99
     vus_max........................: 100    min=100      max=100


running (25.0s), 000/100 VUs, 3625 complete and 0 interrupted iterations
default ✓ [======================================] 000/100 VUs  25s
```
```shell
  execution: local
     script: stress.js
     output: -

  scenarios: (100.00%) 1 scenario, 400 max VUs, 1m25s max duration (incl. graceful stop):
           * default: Up to 400 looping VUs for 55s over 7 stages (gracefulRampDown: 30s, gracefulStop: 30s)


     data_received..................: 5.5 MB 99 kB/s
     data_sent......................: 636 kB 12 kB/s
     http_req_blocked...............: avg=21.71µs  min=0s     med=3µs   max=1.55ms  p(90)=6µs   p(95)=281µs
     http_req_connecting............: avg=14.14µs  min=0s     med=0s    max=1.47ms  p(90)=0s    p(95)=217µs
   ✗ http_req_duration..............: avg=1.75s    min=5.1ms  med=1.68s max=9.22s   p(90)=3.07s p(95)=3.76s
       { expected_response:true }...: avg=1.75s    min=5.1ms  med=1.68s max=9.22s   p(90)=3.07s p(95)=3.76s
     http_req_failed................: 0.00%  ✓ 0          ✗ 7478
     http_req_receiving.............: avg=126.53µs min=10µs   med=95µs  max=11.11ms p(90)=174µs p(95)=252µs
     http_req_sending...............: avg=20.62µs  min=2µs    med=18µs  max=1.36ms  p(90)=30µs  p(95)=42µs
     http_req_tls_handshaking.......: avg=0s       min=0s     med=0s    max=0s      p(90)=0s    p(95)=0s
     http_req_waiting...............: avg=1.75s    min=4.98ms med=1.68s max=9.22s   p(90)=3.07s p(95)=3.76s
     http_reqs......................: 7478   135.036235/s
     iteration_duration.............: avg=1.75s    min=5.21ms med=1.68s max=9.22s   p(90)=3.07s p(95)=3.76s
     iterations.....................: 7478   135.036235/s
     vus............................: 55     min=10       max=400
     vus_max........................: 400    min=400      max=400


running (0m55.4s), 000/400 VUs, 7478 complete and 0 interrupted iterations
default ✓ [======================================] 000/400 VUs  55s
ERRO[0056] thresholds on metrics 'http_req_duration' have been breached
```