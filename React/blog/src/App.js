import './App.css';
import { useState } from "react"; //useState 사용할때 import 해야함

function App() {

  let blogTitle = "New Blog";
  var [articleTitle, b] = useState('블로그 첫 글'); // JS의 Destructuring 문법 사용한 useState생성
  
  return (
    <div className="App">
      <div class="nav">
        <h4 style={{fontSize :'30px'}}>{ blogTitle }</h4>
      </div>
      <div className="list">
        <h4>{ articleTitle }</h4>
        <p>2023.07.57</p>
      </div>
    </div>
  );
}

export default App;
