import './App.css';
import './Navbar.css';
import './Product.css';
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
          <ProductList src={"https://jangmyun.github.io/img/React/Product/AirForce.jpg"}/>
          <ProductList src={"https://jangmyun.github.io/img/React/Product/NikeBasketballShoes.jpg"}/>
          <ProductList src={"https://jangmyun.github.io/img/React/Product/mainBg.jpg"} />
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

function ProductList(props){
  return (
    <Col md={4} lg={4}>
      <img width={'100%'} src={props.src} alt="" />
      <h4>Product Name</h4>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit, blanditiis.
      </p>
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
