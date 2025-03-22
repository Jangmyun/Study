const express = require("express");

const app = express(); // express initializing

const port = 3000;

app.get("/", (req, res) => {
  res.set({ "Content-Type": "text/html; charset=utf-8" });
  res.end("Hello express");
});

app.listen(port, () => {
  console.log(`START SERVER : user ${port}`);
});
