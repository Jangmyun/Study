import './css/App.css';
import './css/Navbar.css';
import './css/Product.css';
import {About, Event} from './Component/Nav';
import ProductDetail from './Component/ProductDetail';
import {Row, Col, Container} from 'react-bootstrap';
import data from './Data';
import {useState , useEffect} from 'react';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';
import styled from 'styled-components';



function App() {
  let [shoes, setShoes] = useState(data);
  let [productId, setProductId] = useState(0);
  let YellowBtn = styled.button`
        background: yellow;
        `

  return ( 
    <div className="App">
      <Navbar></Navbar>
      <Routes>
        <Route path='*' />
        <Route path='/' element={<><div className="main-bg"></div><ProductList productId={productId} setProductId={setProductId} /></>}></Route>
        <Route path='/cart' element={<div>Cart</div>}></Route>
        <Route path='/detail/:id' element={<ProductDetail product={shoes}  />}></Route>
        <Route path='/event' element={<Event/>}>
          <Route path='one' element={<div>첫 주문시 30% 할인</div>} />
          <Route path='two' element={<div>생일기념 할인쿠폰 증정</div>}/>
        </Route>
        <Route path='/about' element={<About/>}>
          <Route path='member'element={<div>우리회사 멤버들</div>}/>
          <Route path='location' element={<div>우리회사 위치</div>}/>
        </Route>
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
        <a href="/about">About</a>
        <a href="/event">Event</a>
      </div>
    </div>
  );
}
function ProductList({productId}){
  let [shoes, setShoes] = useState(data);
  return (
    <Container className='productBox'>
        <Row>
          { // Data.js에서 import 한 data 반복문 돌려서 ProductCard 생성
            shoes.map(function(value, index){
              return(
                <ProductCard id={index} src={"https://jangmyun.github.io/img/React/Product/product"+ (index+1) +".jpg"}
                            title={value.title} content={value.content} price={value.price} productId={productId}
                />
              );
            })
          }
        </Row>
      </Container>
  );
}

function ProductCard({id, src, title, content, price, key}){
  return (
    <Col  xs={6} md={4} lg={4} onClick={()=>{
      window.location.href = "/detail/"+ (id);
    }}>
      <img width={'100%'} src={src} alt="" />
      <h4>{title}</h4>
      <p>{content}</p>
      <h5>{price}원</h5>
    </Col>
  );
}



function Error404Page() {
  return(
    <div className='error-page'>
      <h1>404!</h1>
      <p>Wrong Internet Address!</p>
    </div>
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
