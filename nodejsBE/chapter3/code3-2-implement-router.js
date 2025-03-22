const http = require("http");
const url = require("url");

http
  .createServer((req, res) => {
    // req로 받은 url의 pathname을 읽음. 두번째 파라미터로 쿼리스트링도 함께 파싱할지 여부 결정
    const path = url.parse(req.url, true).pathname;
    res.setHeader("Content-Type", "text/html");

    if (path === "/user") {
      // url pathname 마다 결괏값 설정
      res.end("[user] name : andy, age: 30");
    } else if (path === "/feed") {
      res.end(/*HTML*/ `
      <ul>
        <li>picture 1</li>
        <li>picture 2</li>
        <li>picture 3</li>
      </ul>
    `);
    } else {
      res.statusCode = 404;
      res.end("404 page not found");
    }
  })
  .listen("3000", () => console.log("Router implemented server started"));
