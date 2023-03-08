import http from 'k6/http';
import { check } from 'k6';

export let options = {
  stages: [
    { duration: '5s', target: 5 },
    { duration: '5s', target: 50 },
    { duration: '5s', target: 100 },
    { duration: '5s', target: 50 },
    { duration: '5s', target: 0 }
  ],

  thresholds: {
    http_req_duration: ['p(99)<1500'], // 99% of requests must complete below 1.5s
  },
};

var count = 0;

export default function () {
  var cnt = count++;
  var payload = JSON.stringify({
    title: 'sample title' + cnt,
    content: 'sample content' + cnt,
  });
  var headers = {
    headers: {
      'Content-Type': 'application/json',
    },
  };
  http.post('http://localhost:8080/posts',payload,headers);
}