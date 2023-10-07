import React from 'react';
import {Provider, useSelector, useDispatch} from 'react-redux'
import store from './store'
import {up} from './counterSlice'

function Counter(){
  const count = useSelector(state=> state.counter.value)
  const dispatch = useDispatch();
  return(
    <div>
      <button onClick={()=>{
        dispatch(up(2))
      }}>+</button> {count}
    </div>
  )
}


function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <Counter></Counter>
      </div>
    </Provider>
  );
}



export default App;
