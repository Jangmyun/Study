import {configureStore , createSlice} from '@reduxjs/toolkit';

let user = createSlice({
    name: 'user',
    initialState: {name:'kim', age: 21},
    reducers: {
        setUser(user){
            user.name = 'park';
            user.age = user.age+1;
        }
    }
})
export let {setUser} = user.actions;

let cart = createSlice({
    name: 'cart',
    initialState:[
        {id : 0, name : 'White and Black', count : 2},
        {id : 2, name : 'Grey Yordan', count : 1}
      ] ,
    reducers: {
        setCart(cart, id){
            cart.findIndex( obj => obj.id == id)
        }
    }
})
export default configureStore({
    reducer: {
        user: user.reducer,
        cart: cart.reducer
    }
})