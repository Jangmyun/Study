const http = require("http");

const server = http.createServer((req, res) => {
  res.setHeader("Content-Type", "text/html");
  res.end("OK");
}); // .listen("3000", ...) 같은 형태도 가능

server.listen("3000", () => console.log("OK server started"));
