## 환경
- 전체 데이터 수 : 67577
- 전체 데이터 조회
---
- 페이징 처리 전
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
- 페이징 처리 후
