import React, { useContext } from 'react';
import axios from 'axios';
import { MovieContext } from './context/MovieContext';

const MovieItem = (props) => {
    const movie = props.movie;
    const {reRender} = useContext(MovieContext);

    const releaseDate = new Date (movie.releaseDate)
    
    const deleteMovie = () => {
        axios.delete(`http://localhost:3000/api/movies/delete-movie/${movie._id}`)
        .then((response) => {
        console.log(response);
        reRender();        
    })
        .catch(error => console.error(error))
    }

    return (
        <article>
            <p>Titre: {movie.title} </p>
            <p>Description: {movie.description} </p>
            <p>Réalisateur: {movie.director} </p>
            <p>Date de sortie: {releaseDate.toLocaleDateString()} </p>
            <button onClick={deleteMovie}>Supprimer</button>
        </article>
    );
}

export default MovieItem;
