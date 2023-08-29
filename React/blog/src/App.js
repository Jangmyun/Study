import './App.css';
import { useState } from "react"; //useState 사용할때 import 해야함

function App() {

  let blogTitle = "New Blog";
  let [articleTitle, setArticleTitle] = useState(['블로그 첫 글', '블로그 두번째 글', 'JS 독학']); // JS의 Destructuring 문법 사용한 useState생성
  let [like, setLike] = useState(0);
  
  return (
    <div className="App">

      <div className="nav">
        <h4 style={{fontSize :'30px'}}>{ blogTitle }</h4>
      </div>
      <button onClick={()=>{ 
          let copy = [...articleTitle];
          copy[0] = '가나다라마바사';
          setArticleTitle(copy );
          }}>제목변경</button>

          <button onClick={()=>{
            let copy = [...articleTitle];
            copy.sort();
            setArticleTitle(copy);
          }}>제목 가나다순</button>
      <div className="list">
        <h4>{ articleTitle[0] }   <span onClick={()=>{setLike(++like)}}>👍</span>{like}</h4> {/* setLike함수를 이용해서 like state에 +1씩*/}
        <p>2023.07.23</p>
      </div>
      <div className="list">
        <h4>{ articleTitle[1] }   <span onClick={()=>{setLike(++like)}}>👍</span>{like}</h4>
        <p>2023.07.23</p>
      </div>
      <div className="list">
        <h4>{ articleTitle[2] }   <span onClick={()=>{setLike(++like)}}>👍</span>{like}</h4>
        <p>2023.07.23</p>
      </div>
      
      <Modal></Modal>
    </div>
  );
}
function Modal(){
  return(
    <div className='modal'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}
function Articles(articleTitle) {
  return (
    <div className='list'>
      <h4>{articleTitle}</h4>
      <p>2023.07.23</p>
    </div>
  );
}

export default App;
