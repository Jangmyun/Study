import './App.css';
import './Navbar.css'
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <div className="main-bg"></div>
      <Container className='productBox'>
        <Row>
          <ProductList></ProductList>
        </Row>
      </Container>
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

function ProductList(){
  return (
    <Col md={4} lg={3}>
      <img src="https://jangmyun.github.io/img/softwareThumbnail/soft_thumb02.jpg" alt="" width={'100%'}/>
      <h4>Product Name</h4>
      <p>Product information</p>
    </Col>
  );
}


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
