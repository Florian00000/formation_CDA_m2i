package com.example.exercice2.service;

import com.example.exercice2.Exception.NotFoundException;
import com.example.exercice2.dto.film.FilmDtoGet;
import com.example.exercice2.dto.film.FilmDtoPost;
import com.example.exercice2.entity.Director;
import com.example.exercice2.entity.Film;
import com.example.exercice2.repository.FilmRepository;
import com.example.exercice2.util.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService implements BaseService<FilmDtoPost, FilmDtoGet> {
    @Autowired
    private FilmRepository repository;

    @Autowired
    private DirectorService directorService;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    @Override
    public FilmDtoGet create(FilmDtoPost filmDtoPost) {
        Film film = Film.builder()
                .name(filmDtoPost.getName())
                .description(filmDtoPost.getDescription())
                .duration(filmDtoPost.getDuration())
                .filmType(FilmType.values()[filmDtoPost.getFilmType()])
                .releaseDate(LocalDate.parse(filmDtoPost.getReleaseDateStr(),dateFormatter))
                .director(directorService.getById(filmDtoPost.getDirectorId()))
                .build();

        repository.save(film);
        return filmToFilmDtoGet(film);
    }

    @Override
    public FilmDtoGet update(int id, FilmDtoPost filmDtoPost) {
        Film film = getById(id);
        film.setName(filmDtoPost.getName());
        film.setDescription(filmDtoPost.getDescription());
        film.setDuration(filmDtoPost.getDuration());
        film.setReleaseDate(LocalDate.parse(filmDtoPost.getReleaseDateStr(),dateFormatter));
        film.setFilmType(FilmType.values()[filmDtoPost.getFilmType()]);
        film.setDirector(directorService.getById(filmDtoPost.getDirectorId()));

        repository.save(film);
        return filmToFilmDtoGet(film);
    }

    @Override
    public boolean delete(int id) {
        Film film = getById(id);
        repository.delete(film);
        return true;
    }

    @Override
    public FilmDtoGet findById(int id) {
        return filmToFilmDtoGet(getById(id));
    }

    @Override
    public List<FilmDtoGet> findAll() {
        return filmsTofilmDtoGets((List<Film>) repository.findAll());
    }

    public List<FilmDtoGet> findAllFilmByDirector ( int directorId){
        Director director = directorService.getById(directorId);
        List<Film> filmsByDirector = director.getFilms();
        return filmsTofilmDtoGets(filmsByDirector);
    }

    private Film getById (Integer id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException(id.toString()));
    }

    private FilmDtoGet filmToFilmDtoGet (Film film){
        return FilmDtoGet.builder()
                .id(film.getId())
                .name(film.getName())
                .description(film.getDescription())
                .duration(film.getDuration())
                .filmType(film.getFilmType())
                .releaseDate(film.getReleaseDate())
                .director(film.getDirector())
                .build();
    }

    private List<FilmDtoGet> filmsTofilmDtoGets (List<Film> films){
        return films.stream().map(this::filmToFilmDtoGet).collect(Collectors.toList());
    }

}
