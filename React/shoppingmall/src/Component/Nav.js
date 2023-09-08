import '../css/App.css';
import {Routes, Route, Link, useNavigate, Outlet, useParams} from 'react-router-dom';

import React from 'react';

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

export {About , Event};