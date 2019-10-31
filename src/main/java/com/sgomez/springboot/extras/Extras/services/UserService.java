package com.sgomez.springboot.extras.Extras.services;

import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import com.sgomez.springboot.extras.Extras.models.UserEntity;
import com.sgomez.springboot.extras.Extras.repositories.LocalRepository;
import com.sgomez.springboot.extras.Extras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }


}
