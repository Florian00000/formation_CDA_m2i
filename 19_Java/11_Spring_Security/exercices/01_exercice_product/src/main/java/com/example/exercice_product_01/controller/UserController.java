package com.example.exercice_product_01.controller;

import com.example.exercice_product_01.dto.BaseResponsedto;
import com.example.exercice_product_01.dto.UserLoginDto;
import com.example.exercice_product_01.entity.User;
import com.example.exercice_product_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public BaseResponsedto registerUser(@RequestBody User user) {

        if (userService.createUser(user)){
            return new BaseResponsedto( "Success");
        }else{
            return new BaseResponsedto( "Failed");
        }
    }

    @PostMapping("/login")
    public BaseResponsedto loginUser(@RequestBody UserLoginDto userloginDto) {
        if (userService.checkUserNameExists(userloginDto.getEmail())){

            if(userService.verifyUser(userloginDto.getEmail(),userloginDto.getPassword())){

                Map<String,Object> data = new HashMap<>();
                data.put("token", userService.generateToken(userloginDto.getEmail(), userloginDto.getPassword()));

                return new BaseResponsedto("Success", data);
            }else {
                return new BaseResponsedto("Wrong password" );
            }
        }else {
            return new BaseResponsedto("User don't exist");
        }

    }
}
