let age :number = 21;  // 변수만들 때 타입지정 가능
//타입으로 들어갈 수 있는 것들
// string , number, boolean, null, undefined, bigint, [], {} 등

let names :string[] = ["kim", "park"];
let person :{name? : string } = {name:'kim'};  // name? 은 name이 들어갈 수 도 있고 안들어갈수도 있다는 뜻

// Union type
let unionType :string | number = 123;  //string 또는 number가 들어올 수 있게

// Type alias
type myType = string | number;  // type을 변수에 넣어서 사용 가능
let typeAlias :myType = 123;

// function에 타입지정
function method(x:number /* 파라미터 타입 지정 */) :number /* 리턴타입 지정 */{
    return x*x;
}

// tuple 타입
type tupleType = [number, boolean];
let jane :tupleType = [123, true]; // 첫번째에 숫자 두번째에 boolean 타입이 들어가야하는 tuple



type Member = {
    [key : string] : string,  // string가 key인 모든 object 속성의 타입이 string
}

let john :Member = { name : 'kim', age: '123'}

class User {
    userName : string;
    constructor(name:string){
        this.userName = name;
    }
}