package com.example.demospring.controller;

import com.example.demospring.dto.UserDtoGet;
import com.example.demospring.dto.UserDtoPost;
import com.example.demospring.entity.User;
import com.example.demospring.exception.NotFoundException;
import com.example.demospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maincontroller")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getData() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoGet> getDataById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        UserDtoGet userDtoGet = new UserDtoGet(user.getId(),user.getFirstName(), user.getLastName());
        return ResponseEntity.ok(userDtoGet);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoGet> registerData(@Validated @RequestBody UserDtoPost userDtoPost) {
        User user = userService.create(userDtoPost);
        UserDtoGet userDtoGet = new UserDtoGet(user.getId(),user.getFirstName(), user.getLastName());
        return new ResponseEntity<>(userDtoGet,HttpStatus.CREATED);
    }

    @GetMapping("/notfound")
    public ResponseEntity<String> notfound () {
        throw new NotFoundException();
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> notFoundExceptionHandler (NotFoundException ex){
//        return new ResponseEntity<>("not found entity", HttpStatus.NOT_FOUND);
//    }
}
