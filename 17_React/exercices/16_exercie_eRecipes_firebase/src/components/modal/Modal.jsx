import React from 'react';
import {createPortal} from 'react-dom'
import classes from "./Modal.module.css"

const Modal = (props) => {
    let {changeModal} = props    

    return createPortal (
        <div className={classes.modal} >
            <div className={classes.modalContent} > 
            {props.children} 

            <button onClick={changeModal} >Annuler</button>
            </div>
        </div>,
        document.body
    );
}

export default Modal;
