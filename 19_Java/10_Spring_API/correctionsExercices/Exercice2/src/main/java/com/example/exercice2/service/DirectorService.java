package com.example.exercice2.service;

import com.example.exercice2.Exception.NotFoundException;
import com.example.exercice2.dto.director.DirectorDtoGet;
import com.example.exercice2.dto.director.DirectorDtoPost;
import com.example.exercice2.entity.Director;
import com.example.exercice2.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService implements BaseService<DirectorDtoPost, DirectorDtoGet> {

    @Autowired
    private DirectorRepository repository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");



    @Override
    public DirectorDtoGet create(DirectorDtoPost directorDtoPost) {
        Director director = Director.builder()
                .firstname(directorDtoPost.getFirstname())
                .lastName(directorDtoPost.getLastname())
                .nationality(directorDtoPost.getNationality())
                .birthDate(LocalDate.parse(directorDtoPost.getBirthDateStr(),dateFormatter))
                .build();

        repository.save(director);

        return directorToDirectorDtoGet(director);
    }

    @Override
    public DirectorDtoGet update(int id, DirectorDtoPost directorDtoPost) {
        Director director = getById(id);
        director.setFirstname(directorDtoPost.getFirstname());
        director.setLastName(directorDtoPost.getLastname());
        director.setBirthDate(LocalDate.parse(directorDtoPost.getBirthDateStr(),dateFormatter));
        director.setNationality(directorDtoPost.getNationality());

        repository.save(director);

        return directorToDirectorDtoGet(director);
    }

    @Override
    public boolean delete(int id) {
        Director director = getById(id);
        repository.delete(director);
        return true;
    }

    @Override
    public DirectorDtoGet findById(int id) {
        return directorToDirectorDtoGet(getById(id));
    }

    @Override
    public List<DirectorDtoGet> findAll() {
        return directorsToDirectDtoGets((List<Director>) repository.findAll());
    }

    public Director getById(Integer id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException(id.toString()));
    }

    private DirectorDtoGet directorToDirectorDtoGet (Director director){
        return DirectorDtoGet.builder()
                .id(director.getId())
                .firstname(director.getFirstname())
                .lastName(director.getLastName())
                .birthDate(director.getBirthDate())
                .nationality(director.getNationality())
                .films(director.getFilms())
                .build();
    }

    private List<DirectorDtoGet> directorsToDirectDtoGets (List<Director> directors){
        return directors.stream().map(this::directorToDirectorDtoGet).collect(Collectors.toList());
    }
}
