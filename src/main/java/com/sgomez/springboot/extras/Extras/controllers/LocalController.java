package com.sgomez.springboot.extras.Extras.controllers;

import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import com.sgomez.springboot.extras.Extras.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalController {
    @Autowired
    private LocalService localService;

    @RequestMapping(
            value = "locales",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<LocalEntity> getAll() {
//        List<Local> locales = new ArrayList<>();
//        locales.add(new Local(1, "Encarna"));
//        locales.add(new Local(1, "Vintage"));
//        return locales;

        return localService.findAll();
    }

}
