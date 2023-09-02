import './css/App.css';
import './css/Navbar.css';
import './css/Product.css';
import {Row, Col, Container} from 'react-bootstrap';
import data from './Data';
import {useState} from 'react';
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom';



function App() {
  let [shoes, setShoes] = useState(data);
  let [productId, setProductId] = useState(0);


  return ( 
    <div className="App">
      <Navbar></Navbar>

      

      <Routes>
        <Route path='*' />
        <Route path='/' element={<><div className="main-bg"></div><ProductList productId={productId} setProductId={setProductId} /></>}></Route>
        <Route path='/cart' element={<div>Cart</div>}></Route>
        <Route path='/detail' element={<ProductDetail/>}></Route>
        <Route path='/about' element={<About/>}>
          <Route path='member'element={<div>우리회사 멤버들</div>}/>
          <Route path='location' element={<div>우리회사 위치</div>}/>
        </Route>
      </Routes>

    </div>
  );
}
function About(){
  let navigate = useNavigate();
  return (
    <div>
      <h4>회사에 관하여</h4>
      <button onClick={()=>{navigate('member')}}>멤버</button>
      <button onClick={()=>{ navigate('location')}}>위치</button>
      <Outlet></Outlet>
      
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
                <ProductCard key={index} id={index} src={"https://jangmyun.github.io/img/React/Product/product"+ (index+1) +".jpg"}
                            title={value.title} content={value.content} price={value.price} productId={productId}
                />
              );
            })
          }
        </Row>
      </Container>
  );
}

function ProductCard({id, src, title, content, price}){
  return (
    <Col id={id} xs={6} md={4} lg={4} onClick={()=>{
      window.location.href = "/detail"
    }}>
      <img width={'100%'} src={src} alt="" />
      <h4>{title}</h4>
      <p>{content}</p>
      <h5>{price}원</h5>
    </Col>
  );
}

function ProductDetail({src, title, contnet, price}){
  return(
    <Container onClick={()=>{
      window.location.href = "/";
    }}>
      <Row>
        <Col xs={6}>
          <img src="https://jangmyun.github.io/img/React/Product/product1.jpg" alt="" width={'100%'} />
        </Col>
        <Col xs={6}>
          <h4>Airforce</h4>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet, corrupti.</p>
          <h5>price 원</h5>
        </Col>
      </Row>
    </Container>
  );
}

function Error404Page() {
  return(
    <div>
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
