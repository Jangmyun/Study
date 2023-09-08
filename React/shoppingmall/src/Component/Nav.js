import '../css/App.css';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';

import React from 'react';
function Navbar() {
    return (
      <div className="navbar">
        <div className="navbar-logo" onClick={()=>{
            window.location.href = "/";
        }}>
          <h4>Jangmyun.shop</h4>
        </div>
        <div className="navbar-nav">
          <a className="active" href="/">Home</a>
          <a href="/cart">Cart</a>
          <a href="/about">About</a>
          <a href="/event">Event</a>
          <a href="/detail">Details</a>
        </div>
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
  function Event(){
    let navigate = useNavigate();
    return(
      <div>
        <h4>오늘의 이벤트</h4>
        <button onClick={()=>{navigate('one')}}>1</button>
        <button onClick={()=>{ navigate('two')}}>2</button>
        <Outlet></Outlet>
      </div>
    );
  }

export {Navbar, About, Event};