import React, { useContext, useRef } from "react";
import axios from 'axios';
import { MovieContext } from "./context/MovieContext";

const FormMovie = (props) => {
  const title = props.title;
  const {reRender} = useContext(MovieContext)

  const titleRef = useRef();
  const descriptionRef = useRef();
  const directorRef = useRef();
  const releaseDateRef = useRef();


  const movieForm = (e) => {
    e.preventDefault();
    const movie = {
        title: titleRef.current.value,
        description: descriptionRef.current.value,
        director: directorRef.current.value,
        releaseDate: new Date(releaseDateRef.current.value)
    }
    axios.post(`http://localhost:3000/api/movies/add-movie`, movie)
        .then((response) => {
        console.log(response);
        reRender();        
    })
        .catch(error => console.error(error))

  }

  return (
    <form onSubmit={movieForm}>
      <h2>{title}</h2>
      <div>
        <label htmlFor="title">Titre:</label>
        <input type="text" id="title" required ref={titleRef} />
      </div>
      <div>
        <label htmlFor="description">Description:</label>
        <input type="text" id="description" required ref={descriptionRef} />
      </div>
      <div>
        <label htmlFor="director">Réalisateur:</label>
        <input type="text" id="director" required ref={directorRef} />
      </div>
      <div>
        <label htmlFor="releaseDate">Date de sortie:</label>
        <input type="date" id="releaseDate" required ref={releaseDateRef} />
      </div>
      <button type="submit">Ajouter</button>
    </form>
  );
};

export default FormMovie;
