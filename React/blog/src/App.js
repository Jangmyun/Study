import './App.css';
import React, { useState } from "react"; //useState 사용할때 import 해야함

function App() {
  let [articleTitle, setArticleTitle] = useState(['블로그 첫 글', '블로그 두번째 글', 'JS 독학']); // JS의 Destructuring 문법 사용한 useState생성
  
  let likeArr = articleTitle.map(function(){  // 글 개수만큼 0으로 채워진 배열 생성
    return 0;
  });   
  let [like, setLike] = useState(likeArr);  
  let [modal, setModal] = useState(false);
  let [modalTitle, setmodalTitle] = useState(0);
  let [input, setInput] = useState('');
  let arr = [1,2,3,4];
  
  
  
  
  return (
    <div className="App">
      <Nav></Nav>

      {
        articleTitle.map(function(value, index){
          return (
            <div className="list" key={index}>
              <h4 onClick={(e)=>{
                setModal(!modal);
                setmodalTitle(index);
              }}>{ articleTitle[index] }</h4>
              <div className='likeDelete'>
                
                <span onClick={()=>{
                let copy = [...like];
                copy[index] = copy[index]+1;
                setLike(copy);
                }}>👍 {like[index]}</span>
              
                <button className='delete-btn' onClick={()=>{
                  let copyTitle = copyArr(articleTitle);
                  copyTitle.splice(index,1);
                  setArticleTitle(copyTitle);
                }}>삭제</button>
              </div>
              <p>2023.07.23</p>
            </div>
          );
        })
      }
      
      <input type="text" onChange={(e)=>{ setInput(e.target.value) }} />
      <button onClick={()=>{
        let copyTitle = copyArr(articleTitle);
        copyTitle.unshift(input);
        setArticleTitle(copyTitle);

        let copyLike = copyArr(like);
        copyLike.unshift(0);
        setLike(copyLike);

      }}>글 생성</button>
      

      {
        modal ? <Modal articleTitle={articleTitle} setArticleTitle={setArticleTitle} modalTitle={modalTitle}></Modal> : null
      }
    </div>
  );
}
function copyArr(arr){
  let copy = [...arr];
  return copy;
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
      <h4>{props.articleTitle[props.modalTitle]}</h4>
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
