import logo from './logo.svg';
import './App.css';

function App() {

  let blogTitle = "New Blog";

  return (
    <div className="App">
      <div class="nav">
        <h4 style={{color: 'red', fontSize :'30px'}}>{blogTitle}</h4>   
      </div>
    </div>
  );
}

export default App;
