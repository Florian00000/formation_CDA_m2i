import React from 'react';

const DemoPropsEnfant = (props) => {
    let textData = props.dataTransfert;
    let reactionYaourt = props.reactionYaourt;

    //autre syntaxe
    // let {dataTransfert, reactionYaourt} = props;

    const sayHello = () => {
        console.log("Hello");
    }

    return (
        <div>
            <h3>Demo Props Composent enfant</h3>
            <p>test props: {textData}</p>

            <h3>test button</h3>
            <button onClick={sayHello} className='btn btn-primary'>Hello</button>
            {/* On ne met pas de parenthèse à la fonction, pour pas qu'elle ne se déclanche tout de suite */}

            <br />
            <br />

            <button onClick={reactionYaourt} className='btn btn-primary'>Yaourt</button>
        </div>
    );
}

export default DemoPropsEnfant;
