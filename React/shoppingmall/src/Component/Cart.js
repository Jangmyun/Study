import { useSelector , useDispatch } from 'react-redux';
import './../css/Cart.css';
import {setUser} from './../store';
import { addCount } from './../store';


function Cart(){
    let cart = useSelector((state)=>{return state.cart})
    let user = useSelector((state)=>{return state.user});
    let dispatch = useDispatch();
    return (

        <div className='table-container'>
            <div>{user.name}({user.age})의 장바구니</div>
            <table className='cart-table'>
                <thead className='cart-table-header'>
                    <tr key="">
                        <th>#</th>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>변경하기</th>
                    </tr>
                </thead>
                <tbody className='cart-table-body'>
                    {
                        cart.map((value, index)=>{
                            return (
                                <tr key={index}>
                                    <td>{value.id}</td>
                                    <td>{value.name}</td>
                                    <td>{value.count}</td>
                                    <td>
                                        <button key={index} onClick={(e)=>{
                                            dispatch(addCount(cart[index].id));
                                        }}>+</button>
                                    </td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>
        </div>
    );

}

export {Cart};