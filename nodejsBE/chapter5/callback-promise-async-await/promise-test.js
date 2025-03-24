const DB = [];

function saveDB(user) {
  const oldDBSize = DB.length + 1;

  DB.push(user);
  console.log(`save ${user.name} to DB`);
  return new Promise((resolve, reject) => {
    if (DB.length > oldDBSize) {
      // 성공 시 user 정보 반환
      resolve(user);
    } else {
      // 실패 시 reject 메서드로 에러 발생
      reject(new Error("Save DB Error!"));
    }
  });
}

function sendEmail(user) {
  console.log(`email to ${user.email}`);
  return new Promise((resolve) => {
    resolve(user);
  });
}

function getResult(user) {
  return new Promise((resolve, reject) => {
    resolve(`success register ${user.name}`);
  });
}

function registerByPromise(user) {
  const result = saveDB(user)
    .then(sendEmail)
    .then(getResult)
    .catch((error) => new Error(error))
    .finally(() => console.log("Finally"));
  console.log(result);
  return result;
}

const myUser = {
  email: "andy@test.com",
  password: "1234",
  name: "andy",
};

// const result = registerByPromise(myUser);
// result.then(console.log); // 결과값도 Promise이므로 then() 메서드로 결괏값 확인 가능

const allResult = Promise.all([
  saveDB(myUser),
  sendEmail(myUser),
  getResult(myUser),
]);
allResult.then(console.log);
