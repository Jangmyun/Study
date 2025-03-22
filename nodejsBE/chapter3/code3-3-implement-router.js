const http = require("http");
const url = require("url");

http
  .createServer((req, res) => {
    // req로 받은 url의 pathname을 읽음. 두번째 파라미터로 쿼리스트링도 함께 파싱할지 여부 결정
    const path = url.parse(req.url, true).pathname;
    res.setHeader("Content-Type", "text/html");

    if (path === "/user") {
      // url pathname 마다 결괏값 설정
      user(req, res);
    } else if (path === "/feed") {
      feed(req, res);
    } else {
      notFound(req, res);
    }
  })
  .listen("3000", () => console.log("Router implemented server started"));

const user = (req, res) => {
  res.end("[user] name : andy, age: 30");
};

const feed = (req, res) => {
  res.end(/*HTML*/ `
    <ul>
      <li>picture 1</li>
      <li>picture 2</li>
      <li>picture 3</li>
    </ul>
  `);
};

const notFound = (req, res) => {
  res.statusCode = 404;
  res.end("404 page not found");
};
