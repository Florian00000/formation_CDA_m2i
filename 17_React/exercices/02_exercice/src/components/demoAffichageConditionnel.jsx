import React from 'react';

const DemoAffichageConditionnel = () => {
    let age = 18;
    let monPrenom = "moi"

    if (age >= 18) {
        return (
            <>
                <h3>Demo Affichage conditionnel</h3>
                <p>Bonjour, je suis {monPrenom}, j'ai {age} ans</p>
            </>
        );
        
    }else {
        return (
            <>
                <h3>Demo Affichage conditionnel</h3>
                <p>Bonjour, j'ai moins de 18 ans</p>
            </>
        )
    }    

    // autre technique 
    // {age >= 18 ? <p>majeur<p/> : <p>mineur<p/> }
}

export default DemoAffichageConditionnel;
