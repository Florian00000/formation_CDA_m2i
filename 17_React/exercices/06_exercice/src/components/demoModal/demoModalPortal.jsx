import React from 'react';
import {createPortal} from "react-dom"
import classes from "./demoModalPortal.module.css"

const DemoModalPortal = (props) => {
    let {changeModal} = props;

    return createPortal (
        <div className={classes.modal} >
            <div className={classes.modalContent} > 
            {props.children} 

            <button onClick={changeModal} ># Ferme ta modal</button>
            </div>
        </div>,
        document.body
    );
}

export default DemoModalPortal;
