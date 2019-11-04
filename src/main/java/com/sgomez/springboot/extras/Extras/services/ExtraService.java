package com.sgomez.springboot.extras.Extras.services;

import com.sgomez.springboot.extras.Extras.models.ExtraEntity;
import com.sgomez.springboot.extras.Extras.repositories.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExtraService {
    @Autowired
    ExtraRepository extraRepository;

    public List<ExtraEntity> findAll() {
        return extraRepository.findAll();
    }


}
