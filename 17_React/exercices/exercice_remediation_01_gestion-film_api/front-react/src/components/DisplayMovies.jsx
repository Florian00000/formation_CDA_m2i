import React, { useContext } from 'react';
import { MovieContext } from './context/MovieContext';
import MovieItem from './MovieItem';

const DisplayMovies = () => {
    const { movieList} = useContext(MovieContext);

    if (movieList && movieList.length) {
        return (
            <>
                <section>
                    {movieList.map((movie, index) => (
                        <MovieItem movie={movie} key={index} />
                    ))}
                </section>
            </>
        );
        
    } else {
        return (
            <>
                <p>Pas de films enregistrés pour le moment</p>
            </>
        )
    }

}

export default DisplayMovies;
