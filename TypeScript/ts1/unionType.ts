// 숫자 또는 문자 들어갈수있는 array
let arrayEx1 :(number|string)[] = [1, '2', 3];

// 속성에 숫자 또는 문자 들어갈 수 있는 object
let objectEx1 :{ a: string|number} = {a : 123};

//모든 타입 허용하려면 any
let anyEx1 : any;
anyEx1 = 123;
anyEx1 = 'kim';

// 모든 자료형 허용 unknown (any랑 비슷)
// 근데 좀 더 안전한
let unknownEx1 :unknown;
unknownEx1 = 123;
// 정확한타입 간의 연산만 허용함

let ageEx :string | number;
// ageEx +1;  왜 안됨?
// string에도 +1 되고 number에도 +1 되는데 union type이라 안됨

let userEx :string = 'kim';
let age :undefined|number = undefined;
let married :boolean = false;
let 철수 :unknown[] = [userEx,age,married]