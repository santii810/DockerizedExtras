package com.sgomez.springboot.extras.Extras.controllers;

import com.sgomez.springboot.extras.Extras.models.ExtraEntity;
import com.sgomez.springboot.extras.Extras.services.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExtraController {
    @Autowired
    private ExtraService extraService;

    @RequestMapping(
            value = "extras",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ExtraEntity> getAll() {
        return extraService.findAll();
    }

}
