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
        <a className="active" href="#home">Home</a>
        <a href="#cart">Cart</a>
      </div>
    </div>
  );
}


let navs = document.querySelectorAll('.navbar-nav a');
navs.forEach(function(nav){
  nav.addEventListener('click', function(e){
    if( !(e.currentTarget.classList.contains("active"))){
      navs.forEach(function(nav){
        nav.classList.remove('active');
      })
    }
  })
});

// navs.forEach((nav)=>{
//   nav.addEventListener('click', function(e){
//     if( e.target.classList.contains("selected")){
//       return;
//     }else {
//       navs.forEach((nav)=>{
//         nav.classList.remove("selected");
//       })
//       e.target.classList.add("selected");
//     }
//   })
// })
export default App;
