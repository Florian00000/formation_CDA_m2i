package com.example.exercice_cinematheque_02.service;

import com.example.exercice_cinematheque_02.dto.DirectorDtoGet;
import com.example.exercice_cinematheque_02.dto.DirectorDtoPost;
import com.example.exercice_cinematheque_02.dto.MovieDtoGet;
import com.example.exercice_cinematheque_02.entity.Director;
import com.example.exercice_cinematheque_02.exception.NotFoundException;
import com.example.exercice_cinematheque_02.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DirectorDtoGet directorToDirectorDtoGet (Director director){
        MovieService movieService = new MovieService();
        List<MovieDtoGet> movieDtoGetList = movieService.movieToMovieDtoGetList(director.getMovies());

        return DirectorDtoGet.builder()
                .id(director.getId())
                .firstName(director.getFirstName())
                .lastName(director.getLastName())
                .birthDate(director.getBirthDate())
                .nationality(director.getNationality())
                .movies(movieDtoGetList.stream().peek(movie -> {
                    movie.setDirector(null);
                }).collect(Collectors.toList()))
                .build();
    }

     private List<DirectorDtoGet> directorToDirectorDtoGetList (List<Director> directors){
        return directors.stream().map(this::directorToDirectorDtoGet).collect(Collectors.toList());
     }

    private Director getDirectorById(int id){
        return directorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    //méthodes pour le controller

    public DirectorDtoGet createDirector(DirectorDtoPost directorDtoPost){
        Director director = Director.builder()
                .firstName(directorDtoPost.getFirstName())
                .lastName(directorDtoPost.getLastName())
                .birthDate(LocalDate.parse(directorDtoPost.getBirthDate(), dateFormatter))
                .nationality(directorDtoPost.getNationality())
                .build();
        directorRepository.save(director);
        return directorToDirectorDtoGet(director);
    }

    public DirectorDtoGet getDirector(int id){
        return directorToDirectorDtoGet(getDirectorById(id));
    }

    public List<DirectorDtoGet> getAllDirectors(){
        return directorToDirectorDtoGetList(directorRepository.findAll());
    }

    public DirectorDtoGet updateDirector(int id, DirectorDtoPost directorDtoPost){
        Director director = getDirectorById(id);
        director.setFirstName(directorDtoPost.getFirstName());
        director.setLastName(directorDtoPost.getLastName());
        director.setBirthDate(LocalDate.parse(directorDtoPost.getBirthDate(), dateFormatter));
        director.setNationality(directorDtoPost.getNationality());
        directorRepository.save(director);
        return directorToDirectorDtoGet(director);
    }

    public boolean deleteDirector(int id){
        Director director = getDirectorById(id);
        directorRepository.delete(director);
        return true;
    }
}
