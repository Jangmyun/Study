import {useState , useEffect} from 'react';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';
import {Row, Col, Container} from 'react-bootstrap';
import '../css/Product.css';
import '../css/App.css';

function ProductList({productId, shoes}){
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

function ProductDetail(props){
    let {id} =useParams(); // URL 파라미터에 입력한 내용 가져오기
    let idFound =  props.product.find(function(value){
      return id == value.id;
    });
    let productURL = `https://jangmyun.github.io/img/React/Product/product${+id+1}.jpg`; 
    useEffect(()=>{
      console.log(`${idFound.title} is good`);
    })
    return(
      
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
      </Container>
    );
  }

export  {ProductList, ProductCard, ProductDetail};