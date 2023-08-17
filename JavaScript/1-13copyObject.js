function copyObject(target){        //기존 객체를 복사해서 리턴하는 함수
    var result = {};
    for (var property in target) {
        result[property] = target[property];
    }
    return result;
}

var user = {
    name: 'Jaenam',
    gender: 'male'
};

var user2 = copyObject(user);
user2.name = 'Jung';

if (user !== user2) {
    console.log('user info changed');
}

console.log(user.name, user2.name);
console.log(user == user2);