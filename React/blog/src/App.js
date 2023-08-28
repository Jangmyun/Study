
import './App.css';

function App() {

  let blogTitle = "New Blog";

  return (
    <div className="App">
      <div class="nav">
        <h4 style={{fontSize :'30px'}}>{blogTitle}</h4>   
      </div>
      <div className="list">
        <h4>Articl Title</h4>
        <p>2023.07.57</p>
      </div>
    </div>
  );
}

export default App;
