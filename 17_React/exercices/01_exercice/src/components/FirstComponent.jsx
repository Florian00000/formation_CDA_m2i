import React from 'react';
import classes from "./FirstComponent.module.css"
import loutre from "../assets/images/loutre.webp"

const FirstComponent = () => {



    return ( 
        <div>
            <h3 className={classes.textChartreuse}>Mon premier yaourt</h3>
            <img src={loutre} />
        </div>
     );
}
 
export default FirstComponent;