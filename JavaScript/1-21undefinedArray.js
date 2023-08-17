var arr1 = [undefined, 1];      //undefined를 직접 할당
var arr2 =[];                   //빈 배열에 인덱스1에만 1할당
arr2[1] = 1;
console.log(arr1);  // [undefined, 1]
console.log(arr2);  // [empty, 1]

console.log("빈 요소 배열의 순회");
arr1.forEach(function(v, i) { console.log(v,i); });
arr2.forEach(function(v, i) { console.log(v,i); });

arr1.map(function(v, i){ return v + i; });
arr2.map(function(v, i){ return v + i; });

arr1.filter(function(v){ return !v; });
arr2.filter(function(v){ return !v; });

arr1.reduce(function(p, c, i){ return p+ c+ i; }, '');
arr1.reduce(function(p, c, i){ return p+ c+ i; }, '');

const emptyArr = [];
const undefinedArr = new Array(3);
