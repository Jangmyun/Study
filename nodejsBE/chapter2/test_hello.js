import http from "k6/http";

// test options
export const options = {
  vus: 100, // 유저 100명이
  duration: "10s", // 10초간 요청을 보내는 설정
};

export default function () {
  http.get("http://localhost:8000"); // http get 요청을 보냄
}
