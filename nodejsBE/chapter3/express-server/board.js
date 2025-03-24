const express = require("express");
const app = express();
let posts = [];

app.use(express.json()); // JSON 미들웨어 활성화 (req.body 사용을 위함)

// post 요청 시 컨텐트 타입이 application/x-www-form-urlencoded인 경우 파싱
app.use(express.urlencoded({ extended: true }));

app.get("/", (req, res) => {
  res.json(posts); // 게시글 리스트를 JSON 형식으로 표시
});

app.post("/posts", (req, res) => {
  const { title, name, text } = req.body; // HTTP req body 데이터를 변수에 할당

  posts.push({ id: posts.length + 1, title, name, text, created_at: Date() });
  res.json({ title, name, text });
});

app.delete("/posts/:id", (req, res) => {
  const id = req.params.id; // app.delete의 path정보에서 id값을 가져옴
  const filteredPosts = posts.filter((post) => post.id !== +id); // post 삭제 로직
  const isLengthChanged = posts.length !== filteredPosts.length;
  posts = filteredPosts;
  if (isLengthChanged) {
    res.json("OK");
    return;
  }

  res.json("NOT CHANGED");
});

app.listen(3000, () => {
  console.log("welcome posts");
});
