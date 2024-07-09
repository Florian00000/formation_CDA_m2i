package com.example.exercice_cinematheque_02.service;

import com.example.exercice_cinematheque_02.dto.DirectorDtoGet;
import com.example.exercice_cinematheque_02.dto.MovieDtoGet;
import com.example.exercice_cinematheque_02.dto.MovieDtoPost;
import com.example.exercice_cinematheque_02.entity.Director;
import com.example.exercice_cinematheque_02.entity.Movie;
import com.example.exercice_cinematheque_02.exception.NotFoundException;
import com.example.exercice_cinematheque_02.repository.DirectorRepository;
import com.example.exercice_cinematheque_02.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private DirectorRepository directorRepository;

    private MovieDtoGet movieToMovieDtoGet (Movie movie) {

        return MovieDtoGet.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .description(movie.getDescription())
                .description(movie.getDescription())
                .duration(movie.getDuration())
                .genre(movie.getGenre())
                .director( movie.getDirector().getFirstName() +" " + movie.getDirector().getLastName())
                .build();
    }

    public List <MovieDtoGet> movieToMovieDtoGetList (List<Movie> movies) {
        return movies.stream().map(this::movieToMovieDtoGet).collect(Collectors.toList());
    }

    private Movie getMovieById (int id) {
        return movieRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    //méthodes pour le controller

    public MovieDtoGet createMovie (MovieDtoPost movieDtoPost) {
        Movie movie = Movie.builder()
                .title(movieDtoPost.getTitle())
                .releaseDate(LocalDate.parse(movieDtoPost.getReleaseDate(), dateFormatter))
                .description(movieDtoPost.getDescription())
                .duration(movieDtoPost.getDuration())
                .genre(movieDtoPost.getGenre())
                .director(movieDtoPost.getDirector())
                .build();
        movieRepository.save(movie);
        return movieToMovieDtoGet(movie);
    }

    public MovieDtoGet getMovie (int id) {
        return movieToMovieDtoGet(getMovieById(id));
    }

    public List<MovieDtoGet> getAllMovies () {
        return movieToMovieDtoGetList(movieRepository.findAll());
    }

    public MovieDtoGet updateMovie (int id, MovieDtoPost movieDtoPost) {
        Movie movie = getMovieById(id);
        movie.setTitle(movieDtoPost.getTitle());
        movie.setReleaseDate(LocalDate.parse(movieDtoPost.getReleaseDate(), dateFormatter));
        movie.setDescription(movieDtoPost.getDescription());
        movie.setDuration(movieDtoPost.getDuration());
        movie.setDuration(movieDtoPost.getDuration());
        movie.setGenre(movieDtoPost.getGenre());
        movie.setDirector(movieDtoPost.getDirector());
        movieRepository.save(movie);
        return movieToMovieDtoGet(movie);
    }

    public boolean deleteMovie (int id) {
        Movie movie = getMovieById(id);
        movieRepository.delete(movie);
        return true;
    }

    public List<MovieDtoGet> getMoviesByIdDirector (int id) {

        Director director = directorRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Movie> movies = movieRepository.findAllByDirector(director);
        return movieToMovieDtoGetList(movies);
    }
}
