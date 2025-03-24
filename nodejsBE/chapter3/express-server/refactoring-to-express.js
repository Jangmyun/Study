const url = require("url");
const express = require("express");
const app = express();
const port = 3000;

app.listen(port, () => {
  console.log(`express router refactoring, ${port}port`);
});

app.get("/", (_, res) => res.end("HOME"));
app.get("/user", user);
app.get("/feed", feed);

function user(req, res) {
  // query string data
  const userInfo = url.parse(req.url, true).query;
  res.json(`[user] name : ${userInfo.name}, age: ${userInfo.age}`);
}

function feed(req, res) {
  res.json(/*HTML*/ `
    <ul>
      <li>picture 1</li>
      <li>picture 2</li>
      <li>picture 3</li>
    </ul>
  `);
}
