import './App.css';
import { useState } from "react"; //useState 사용할때 import 해야함

function App() {
  let [articleTitle, setArticleTitle] = useState(['블로그 첫 글', '블로그 두번째 글', 'JS 독학']); // JS의 Destructuring 문법 사용한 useState생성
  
  let likeArr = articleTitle.map(function(){  // 글 개수만큼 0으로 채워진 배열 생성
    return 0;
  });   
  let [like, setLike] = useState(likeArr);  
  let [modal, setModal] = useState(false);
 

  
  return (
    <div className="App">
      <Nav></Nav>

      {
        articleTitle.map(function(value, index){
          return (
            <div className="list" key={index}>
              <h4 onClick={()=>{
                setModal(!modal);
              }}>{ articleTitle[index] }   <span onClick={()=>{
                let copy = [...like];
                copy[index] = copy[index]+1;
                setLike(copy);
              }}>👍</span>{like[index]}</h4>
              <p>2023.07.23</p>
            </div>
          );
        })
      }

      <button onClick={()=>{
        setModal(!modal);
      }}>modal</button>
      
      {
        modal ? <Modal articleTitle={articleTitle} setArticleTitle={setArticleTitle}></Modal> : null
      }
    </div>
  );
}
function Nav(){
  return(
    <div className="nav">
      <h4 style={{fontSize :'40px'}}>세상에서 벌어지는 장면들</h4>
    </div>
  );
}
function Modal(props){
  return(
    <div className='modal'>
      <h4>{props.articleTitle[0]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <button onClick={()=>{
        props.setArticleTitle(editTitle(props.articleTitle));
      }}>글 수정</button>
    </div>
  );
}

function editTitle(articleTitle){
  let copy = [...articleTitle];
  copy[0] = '블로그 고인물';
  return copy;
}


export default App;
