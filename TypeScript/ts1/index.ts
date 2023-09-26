let nam = 'kim';

type Member = {
    [key : string] : string,  // string가 key인 모든 object 속성의 타입이 string
}

let john :Member = { name : 'kim', age: '123'}

class User {
    name : string;
    constructor(name:string){
        this.name = name;
    }
}