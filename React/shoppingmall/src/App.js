import './css/App.css';
import './css/Navbar.css';
import './css/Product.css';
import {Navbar,About, Event} from './Component/Nav';
import {ProductList, ProductCard, ProductDetail} from './Component/Product';
import {Row, Col, Container} from 'react-bootstrap';
import data from './Data';
import {useState , useEffect} from 'react';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';


function App() {
  let [shoes, setShoes] = useState(data);
  let [productId, setProductId] = useState(0);
  return ( 
    <div className="App">
      <Navbar></Navbar>
      <Routes>
        <Route path='*' />
        <Route path='/' element={<><div className="main-bg"></div><ProductList shoes={shoes} setShoes={setShoes} productId={productId} setProductId={setProductId} /></>}></Route>
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
      <div style={{height: '500px'}}></div>
    </div>
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
export default App;
