import React from 'react';
import DemoPropsEnfant from './DemoPropsEnfant';

const DemoProps = () => {
    let donneDuParent = "Bonjour je suis une donnée, à ne pas confondre avec mon homologue anglaise: la Data";

    const reactionYaourt = () => {
        alert("mmh yaourt!!");
    }

    return (
        <div>
            <h3>Demo Props Composent parent</h3>
            <DemoPropsEnfant dataTransfert={donneDuParent} reactionYaourt={reactionYaourt}/>
        </div>
    );
}

export default DemoProps;
