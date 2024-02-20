import React from 'react';
import { useState } from 'react';

const FormulaireExercice6 = (props) => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");

    let {ajouterContact} = props
    

    const changeFirstName = (e) => {
        setFirstName(e.target.value);
    }

    const changeLastName = (e) => {
        setLastName(e.target.value);
    }

    const changeEmail = (e) => {
        setEmail(e.target.value);
    }

    const envoieContact = () => {
        if (firstName && lastName && email) {
            const newContact = {firstName: firstName, lastName:lastName, email:email} 
            ajouterContact(newContact)
            setFirstName("");
            setLastName("");
            setEmail('');              
            
        }else{
            alert("Formulaire incorrect")
        }
    }

    return (
        <>
            <div>
                <label htmlFor="firstName">Votre prénom</label>
                <input type="text" id='firstName' value={firstName} onInput={changeFirstName}/>
            </div>
            <div>
                <label htmlFor="lastName">Votre Nom</label>
                <input type="text" id='lastName' value={lastName} onInput={changeLastName}/>
            </div>
            <div>
                <label htmlFor="email">Votre Email</label>
                <input type="email" id='email' value={email} onInput={changeEmail}/>
            </div>
            <button onClick={envoieContact}>Ajouter Contact</button>            
        </>
    );
}

export default FormulaireExercice6;
