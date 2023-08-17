var user = {
    name: 'Jaenam',
    gender: 'male'
};

var changeName = function (user, newName) {
    return {                //새로운 객체를 리턴
        name:newName,
        gender:user.gender
    };
};

var user2 = changeName(user, 'Jung');

if (user !== user2) {
    console.log('user info changed');
}

console.log(user.name, user2.name);
console.log(user == user2);