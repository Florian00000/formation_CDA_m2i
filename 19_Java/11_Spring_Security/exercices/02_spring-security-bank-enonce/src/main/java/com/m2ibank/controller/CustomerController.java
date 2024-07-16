package com.m2ibank.controller;

import com.m2ibank.dto.BaseResponsedto;
import com.m2ibank.dto.CustomerLoginDto;
import com.m2ibank.model.Customer;
import com.m2ibank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public BaseResponsedto registerCustomer(@RequestBody Customer customer) {

        if (customerService.createCustomer(customer)){
            return new BaseResponsedto( "Success");
        }else{
            return new BaseResponsedto( "Failed");
        }
    }

    @PostMapping("/login")
    public BaseResponsedto login(@RequestBody CustomerLoginDto customerLoginDto) {
        if (customerService.checkUsernameExists(customerLoginDto.getEmail())){

            if (customerService.verifyCustomer(customerLoginDto.getEmail(), customerLoginDto.getPwd())){
                Map<String, Object> data = new HashMap<>();
                int id = customerService.getIdByEmail(customerLoginDto.getEmail()); ;
                data.put("token", customerService.generateToken(customerLoginDto.getEmail(), customerLoginDto.getPwd(), id));
                return new BaseResponsedto("Success",data);
            }
        }
        return new BaseResponsedto("Connection Failed");
    }
}
