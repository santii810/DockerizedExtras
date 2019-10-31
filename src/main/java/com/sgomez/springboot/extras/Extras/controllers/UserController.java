package com.sgomez.springboot.extras.Extras.controllers;

import com.sgomez.springboot.extras.Extras.models.UserEntity;
import com.sgomez.springboot.extras.Extras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<UserEntity> getAll() {
        return userService.findAll();
    }

}
