import {useState , useEffect} from 'react';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';
import {Row, Col, Container} from 'react-bootstrap';
import '../css/Product.css';
import '../css/App.css';

function ProductDetail(props){
    let {id} =useParams(); // URL 파라미터에 입력한 내용 가져오기
    let idFound =  props.product.find(function(value){
      return id == value.id;
    });
    let productURL = `https://jangmyun.github.io/img/React/Product/product${id+1}.jpg`; 
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

export default ProductDetail;