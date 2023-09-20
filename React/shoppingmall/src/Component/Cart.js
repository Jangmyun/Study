import { useSelector } from 'react-redux';
import './../css/Cart.css';

function Cart(){
    let a = useSelector((state)=>{return state})
    console.log(a.user);
    return (
        <div className='table-container'>
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
                    <tr key="">
                        <td>1</td>
                        <td>hi</td>
                        <td>hi</td>
                        <td>hi</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );

}

export {Cart};