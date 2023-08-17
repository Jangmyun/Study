var copyObjectViaJSON = function (target) {
    return JSON.parse(JSON.stringify(target));      //target을 JSON 문자열로 변환했다가 JS 객체로 변환
}

var obj = {
    a: 1,
    b: {
        c: null,
        d: [1,2],
        func1: function() { console.log(3); }
    },
    func2: function() { console.log(4); }           //메서드나 __proto__ , getter/setter 같은 애들은 JSON으로 안됨
};

var obj2 = copyObjectViaJSON(obj);

console.log(obj);
console.log(obj2);  
