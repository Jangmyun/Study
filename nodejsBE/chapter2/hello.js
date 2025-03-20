const http = require("http"); // http module 불러오기
let count = 0;

// server 인스턴스 생성, 콜백함수에는 http요청을 처리할 함수 설정
const server = http.createServer((req, res) => {
  log(count);
  res.statusCode = 200; // 200 성공
  res.setHeader("Content-Type", "text/plain");
  res.write("hello\n");
  setTimeout(() => {
    res.end("Node.js");
  }, 2000);
});

function log(count) {
  console.log((count += 1));
}

server.listen(8000, () => {
  console.log("Hello Node.js");
});
