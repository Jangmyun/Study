const http = require("http");
const url = require("url");

http
  .createServer((req, res) => {
    // req로 받은 url의 pathname을 읽음. 두번째 파라미터로 쿼리스트링도 함께 파싱할지 여부 결정
    const path = url.parse(req.url, true).pathname;
    res.setHeader("Content-Type", "text/html");

    if (path in urlMap) {
      // urlMap에 path가 있는지 확인
      urlMap[path](req, res); // urlMap에 path값으로 매핑된 함수 실행
    } else {
      notFound(req, res);
    }
  })
  .listen("3000", () => console.log("Router implemented server started"));

const user = (req, res) => {
  // query string data
  const userInfo = url.parse(req.url, true).query;
  res.end(`[user] name : ${userInfo.name}, age: ${userInfo.age}`);
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

const urlMap = {
  "/": (req, res) => res.end("HOME"),
  "/user": user,
  "/feed": feed,
};
