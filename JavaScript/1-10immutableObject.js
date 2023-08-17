var user = {
    name: 'Jaenam',
    gender: 'male'
};

var changeName = function (user, newName) {
    var newUser = user;             // 새 변수에 user 객체의 주소가 대입됨
    newUser.name = newName;         // newUser는 기존 user객체의 주소를 가지고 있어서 newUser 바꾸면 user도 바뀜;
    return newUser;
};

var user2 = changeName(user, 'Jung');

if (user !== user2) {
    console.log('user info changed');
}

console.log(user.name, user2.name);
console.log(user == user2);