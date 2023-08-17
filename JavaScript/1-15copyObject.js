function copyObject(target){        //기존 객체를 복사해서 리턴하는 함수
    var result = {};
    for (var property in target) {
        result[property] = target[property];
    }
    return result;
}

var copyObjectDeep = function(target) { //깊은 복사를 수행하는 함수
    var result = {};

    if (typeof target === 'object' && target !== null){ //typeof 가 null도 object로 리턴하기 때문에 target !== null 조건문 덧붙임
        for( var property in target) {
            result[property] = copyObjectDeep(target[property]);    //copyObjectDeep 함수를 재귀적으로 수행
        }
    } else {        //target이 객체가 아닌 경우
        result = target;    //result에 target값 그대로 지정
    }
    return result;
}

var user = {
    name: 'Kim',
    urls : {            //중첩된 객체
        portfolio: 'github.com/abc',
        blog: 'blog.com',
        facebook: 'facebook.com/abc'
    }
};

var user2 = copyObject(user);
user2.urls = copyObject(user.urls);     //중첩된 객체에 대한 '깊은 복사'

var user3 = copyObjectDeep(user2);

user2.urls.blog = 'abc';
console.log(user2.urls.blog === user3.urls.blog);
console.log(`user2.urls.blog = ${user2.urls.blog} , user3.urls.blog = ${user3.urls.blog}`);
