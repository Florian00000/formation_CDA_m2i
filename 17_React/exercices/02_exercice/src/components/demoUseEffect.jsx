import React, { useEffect, useState } from 'react';

const DemoUseEffect = () => {
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [fullName, setFullName] = useState("")

    const [chrono, setChrono] = useState(0)

    const firstNameHandler = (e) => {
        setFirstName(e.target.value)
    }

    const lastNameHandler = (e) => {
        setLastName(e.target.value)
    }

    useEffect(() => {
        console.log("Application démarré");
    }, [])// si le tableau reste de dépendance rest vide, l effet est appelé au lancement de l'application

    useEffect(() => {
        setFullName(firstName + " " + lastName)
    }, [firstName, lastName])// la fonction se déclanche quand firsname ou lastname change d'état

    useEffect(() => {
        let time = setInterval(()=> {
            setChrono(chrono + 1)
        }, 1000)
    })// Si on ne met pas de tableau de dépendance, le use effect se déclanche à n'importe quel changement d'état

    return (
        <div>
            <input type="text" value={firstName} onInput={firstNameHandler} />
            <input type="text" value={lastName} onInput={lastNameHandler} />
            <p> {fullName} </p>
            <hr />
            <p>chrono</p>
            <p> {chrono} </p>
        </div>
    );
}

export default DemoUseEffect;
