package com.sgomez.springboot.extras.Extras.controllers;

import com.sgomez.springboot.extras.Extras.exceptions.ResourceNotFoundException;
import com.sgomez.springboot.extras.Extras.models.ExtraEntity;
import com.sgomez.springboot.extras.Extras.services.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ExtraController {
    @Autowired
    private ExtraService extraService;

    @GetMapping("extras")
    public List<ExtraEntity> getAll() {
        return extraService.findAll();
    }


    @GetMapping("/extra/{id}")
    public ExtraEntity retrieveStudent(@PathVariable int id) {
        ExtraEntity extra = extraService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Extra", "id", id));
        return extra;
    }

    @PostMapping("extra")
    public ResponseEntity<?> save(ExtraEntity extra) {
        ExtraEntity savedExtra = extraService.save(extra);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedExtra.getId()).toUri();
        return new ResponseEntity<>(location.toString(), HttpStatus.CREATED);
    }


    @DeleteMapping("extra/{id}")
    public ExtraEntity delete(@PathVariable("id") int extra) {
        return extraService.delete(extra);
    }


    //    @PutMapping("/extra/{id}")
    @RequestMapping(value = "/extra/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ExtraEntity updateNote(@PathVariable(value = "id") int id,
                                  @Valid @RequestBody ExtraEntity details) {
        return extraService.update(id, details);
    }
}
