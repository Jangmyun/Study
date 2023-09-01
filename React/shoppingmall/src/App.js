import './App.css';
import './Navbar.css'


function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
        
    </div>
  );
}

function Navbar() {
  return (
    <div className="navbar">
      <div className="navbar-logo">
        <h4>Jangmyun.shop</h4>
      </div>
      <div className="navbar-nav">
        <a href="#home">Home</a>
        <a href="#cart">Cart</a>
      </div>
    </div>
  );
}

export default App;
