package com.example.endofgame.service;

import com.example.endofgame.entity.Person;
import com.example.endofgame.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    public PersonService(final PersonRepository repository) {
        this.repository = repository;
    }

    public Person getMyPerson(){
        log.info("getMyPerson()");
        return repository.findMe();
    }
}
