import React from 'react';
import {createPortal} from 'react-dom'
import classes from './modal.module.css'

const Modal = (props) => {
    let {changeModal} = props;

    return createPortal (
        <div className={classes.modal} >
            <div className={classes.modalContent} > 
            {props.children} 
            <hr />

            <button onClick={changeModal} className='btn btn-dark rounded-1 mb-2 w-100' >Annuler</button>
            </div>
        </div>,
        document.body
    );
}

export default Modal;
