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