package com.example.endofgame.controller;

import com.example.endofgame.entity.Person;
import com.example.endofgame.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public Person representMe(){
        log.info("representMe()");
        return service.getMyPerson();
    }
}
