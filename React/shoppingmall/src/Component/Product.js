import {useState , useEffect} from 'react';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';
import {Row, Col, Container, Tab, Fade} from 'react-bootstrap';
import '../css/Product.css';
import '../css/App.css';
import styled from 'styled-components';
import axios from 'axios';

function ProductList({productId, shoes, setShoes}){
  return (
    <Container className='productBox'>
        <Row>
          { // Data.js에서 import 한 data 반복문 돌려서 ProductCard 생성
            shoes.map(function(value, index){
              return(
                <ProductCard id={value.id} src={"https://jangmyun.github.io/img/React/Product/product"+ (index+1) +".jpg"}
                title={value.title} content={value.content} price={value.price} key={value.id}
                />
              );
            })
          }
          <button onClick={()=>{
          axios.get('https://jangmyun.github.io/data/json/productData2.json')
          .then((result)=>{
            let copy = [...shoes, ...result.data];
            setShoes(copy);
          });
        }}>불러오기</button>
        </Row>
        
      </Container>
  );
}

function ProductCard({id, src, title, content, price}){
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

function ProductDetail(props){
    let [tabContents, setTabContents] = useState(0);
    let {id} =useParams(); // URL 파라미터에 입력한 내용 가져오기
    let idFound =  props.product.find(function(value){
      return id == value.id;
    });
    useEffect(()=>{
      let timeLimit = document.getElementById('time-limit');
      let discountBanner = document.querySelector('.discount-banner');
      setInterval(()=>{
        timeLimit.innerText--;
        if(timeLimit.innerText<'0'){
          discountBanner.style.opacity = 0;
        }
      }, 1000);
    });
    let productURL = `https://jangmyun.github.io/img/React/Product/product${+id+1}.jpg`; 
    return(
      <>
      <Container className='detail' onClick={()=>{
        window.location.href = "/";}}>
        <Row>
          <Col xs={6}>
            <img src={productURL} alt="" width={'100%'} />
          </Col>
          <Col xs={6}>
            <h4>{idFound.title}</h4>
            <p>{idFound.content}</p>
            <h5>{idFound.price} 원</h5>
          </Col>
        </Row>
        <div className='discount-banner'><span id='time-limit'>2</span>초 이내 구매시 할인</div>
      </Container>
      <div className='tab-buttons' style={{display:'flex'}}>
        <button onClick={()=>{
          setTabContents(0);
        }}>button 0</button>
        <button onClick={()=>{
          setTabContents(1);
        }}>button 1</button>
        <button onClick={()=>{
          setTabContents(2);
        }}>button 2</button>
      </div>
      <TabContent tabContents={tabContents}></TabContent>
    </>
    );
  }
function TabContent({tabContents}){ // 컴포넌트 내부에서 if문으로 html 요소 리턴시키면 if문 사용가능
  let [fade, setFade] = useState('');
  
  useEffect(()=>{
    setFade('fade');
    
    return ()=>{
      setFade('');
    }
  })
  // if(props.tabContents ==0){
  //   return <div>content 0</div>
  // }
  // if(props.tabContents == 1){
  //   return <div>content 1</div>
  // }
  // if(props.tabContents == 2){
  //   return <div>content 2</div>
  // }
  return(
    <div className={'tab-content '+ fade}>
      { [<div>content 0</div>, <div>content 1</div>, <div>content 2</div>][tabContents]}
    </div>
  );
}
export  {ProductList, ProductCard, ProductDetail};