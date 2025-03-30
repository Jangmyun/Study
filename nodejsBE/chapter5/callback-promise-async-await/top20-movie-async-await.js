const axios = require("axios");

async function getTop20Movies() {
  const url =
    "https://raw.githubusercontent.com/wapj/jsbackend/main/movieinfo.json";

  try {
    const result = await axios.get(url);
    const { data } = result;

    if (!data.articleList || data.articleList.size == 0) {
      throw new Error("No Data");
    }

    const movieInfos = data.articleList.map((article, i) => {
      return { title: article.title, rank: i + 1 };
    });

    for (let movieInfo of movieInfos) {
      console.log(`[${movieInfo.rank}위] ${movieInfo.title}`);
    }
  } catch (error) {
    throw new Error(err);
  }
}

getTop20Movies();
