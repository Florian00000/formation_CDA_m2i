import React from 'react';
import {useParams, useSearchParams} from 'react-router-dom'

const Project = () => {
    const {monparams} = useParams()

    const [searchParams, setSearchParams] = useSearchParams();
    const mode = searchParams.get("mode") ?? "defaut" //si il ne trouve rien, on met une valeur par défaut
    const toto = searchParams.get("toto") ?? 0

    return (
        <div>
            <h3>Pojet, démo router dynamique</h3>

            <h1>Ma page projet n° {monparams} </h1>

            <p>Message {mode} </p>
            <p>Question? {toto} </p>
        </div>
    );
}

export default Project;
