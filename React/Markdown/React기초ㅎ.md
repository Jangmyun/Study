# 리액트 기초

---



## `map` 반복문 써서 html 요소 여러개 만들기

#### `map()` : 메서드는 배열요소 하나마다 함수 호출하고 callback함수 리턴값을 모은 배열 리턴함

```javascript
let arr = ['a', 'b', 'c', 'd'];
arr.map(function(currentValue, index, array){
  console.log(currentValue);	// 반복중 현재요소의 값
  console.log(index);	//반복중 현재요소의 인덱스
  console.log(array);	// map 메서드를 호출한 배열전체
})
```



### 블로그 글 리스트를 이걸 써서 만들면 될듯하다.

```react
function App(){
  articleTitle.map(function(value, i){
    return (
      <div className="list">
        <h4>{value}</h4>
        <p>2023.08.29</p>
      </div>
    );
  })
}
```

#### 여기다가 좋아요도 개별로 만들어봄

```react
function App(){
  let likeArr = articleTitle.map(function(){
    return 0;	//articleTitle배열의 길이만큼 0으로 채워진 배열 생성
  })
}
```







## props

### 부모 컴포넌트로부터 자식 컴포넌트로 state 전송 가능함<br>그 때 사용하는게 props

```react
{
  modal == true ? <Modal articleTitle={articleTitle}></Modal>
}
```

#### 자식 컴포넌트에 state이름으로 `작명={state이름}` 넘겨주고

```react
function Modal(props){
  return(
  	<div className='modal'>
      <h4>props.state이름</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}
```

#### 자식 컴포넌트 파라미터로 `props` 넘긴다음 `props.작명`으로 state값 사용하면 됨

