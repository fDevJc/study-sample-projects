import http from 'k6/http';
import { check } from 'k6';

export let options = {
  stages: [
    { duration: '5s', target: 50 },
    { duration: '10s', target: 200 },
    { duration: '10s', target: 400 },
    { duration: '10s', target: 300 },
    { duration: '10s', target: 300 },
    { duration: '5s', target: 200 },
    { duration: '5s', target: 50 },
  ],

  thresholds: {
    http_req_duration: ['p(99)<1500'], // 99% of requests must complete below 1.5s
  },
};

export default function () {
  http.get('http://localhost:8080/posts');
}