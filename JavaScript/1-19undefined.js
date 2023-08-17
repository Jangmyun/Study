// JS엔진이 자동으로 undefined를 부여하는 경우
console.log('JS엔진이 자동으로 undefined를 부여하는 경우');

//  1) 값을 대입하지 않은 (데이터 영역 메모리주소를 지정하지 않은) 변수에 접근할 때
var a;
console.log(a);     //undefined

//  2) 객체에 존재하지 않는 프로퍼티에 접근할 때
var obj = { a: 1};
console.log(obj.b); //undefined

//  3) 함수에 return값이 없거나 호출되지 않는 함수의 실행결과
var func = function(){};
var c = func();
console.log(c);

// 값을 대입하지 않은 배열의 경우 특이함
console.log("값을 대입하지 않은 배열의 경우");
var arr1 = [];
arr1.length =3;
console.log(arr1);

var arr2 = new Array(3);
console.log(arr2);

console.log(`값을 대입하지 않은 경우 undefined조차 할당되지 않음`)

//이런 빈 요소는 forEach 같이 배열요소를 순회하는 Array 메서드에 대해 다르게 동작함
