import './App.css';
import './Navbar.css';
import './Product.css';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import data from './Data';
import { useState } from 'react';



function App() {
  let [shoes, setShoes] = useState(data);


  return (
    <div className="App">
      <Navbar></Navbar>
      <div className="main-bg"></div>
      <Container className='productBox'>
        <Row>
          { // Data.js에서 import 한 
            shoes.map(function(value, index){
              return(
                <ProductCard  src={"https://jangmyun.github.io/img/React/Product/product"+ (index+1) +".jpg"}
                            title={value.title} content={value.content} price={value.price}
                />
              );
            })
          }
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

function ProductCard({src, title, content, price}){
  return (
    <Col xs={6} md={4} lg={4}>
      <img width={'100%'} src={src} alt="" />
      <h4>{title}</h4>
      <p>{content}</p>
      <h5>{price}원</h5>
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
