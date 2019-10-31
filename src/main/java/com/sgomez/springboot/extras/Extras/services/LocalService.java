package com.sgomez.springboot.extras.Extras.services;

import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import com.sgomez.springboot.extras.Extras.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocalService {
    @Autowired
    LocalRepository localRepository;

    public List<LocalEntity> findAll() {
        return localRepository.findAll();
    }


}
