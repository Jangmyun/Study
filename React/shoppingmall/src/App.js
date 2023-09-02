import './App.css';
import './Navbar.css';
import './Product.css';
import {Row, Col, Container} from 'react-bootstrap';
import data from './Data';
import {useState} from 'react';
import {Routes, Route, Link} from 'react-router-dom';



function App() {
  let [shoes, setShoes] = useState(data);


  return (
    <div className="App">
      <Navbar></Navbar>

      <div className="main-bg"></div>

      <Routes>
        <Route path='/' element={<ProductList />}></Route>
        <Route path='/cart' element={<div>Cart</div>}></Route>
      </Routes>
      
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
        <a className="active" href="/">Home</a>
        <a href="/cart">Cart</a>
      </div>
    </div>
  );
}
function ProductList(){
  let [shoes, setShoes] = useState(data);
  return (
    <Container className='productBox'>
        <Row>
          { // Data.js에서 import 한 data 반복문 돌려서 ProductCard 생성
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
