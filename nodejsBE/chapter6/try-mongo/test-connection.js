const { MongoClient, ServerApiVersion } = require("mongodb");
const uri =
  "mongodb+srv://cndlsrb2739:09DAHY5L5Igv6gEn@cluster0.tkzrdcu.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
// 프로토콜이 mongodb+srv임

// Create a MongoClient with a MongoClientOptions object to set the Stable API version
const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  },
});

async function run() {
  await client.connect();
  const adminDB = client.db("test").admin();
  const listDatabases = await adminDB.listDatabases();
  console.log(listDatabases);
  return "OK";
}
run()
  .then(console.log)
  .catch(console.error)
  .finally(() => client.close());
