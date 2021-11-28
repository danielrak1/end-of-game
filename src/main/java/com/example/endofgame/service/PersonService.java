package com.example.endofgame.service;

import com.example.endofgame.dto.PersonSummary;
import com.example.endofgame.mapping.PersonConverter;
import com.example.endofgame.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    private final PersonConverter personConverter;

    public PersonService(final PersonRepository repository, final PersonConverter personConverter) {
        this.repository = repository;
        this.personConverter = personConverter;
    }

    public PersonSummary getMyPerson(){
        log.info("getMyPerson()");
        return personConverter.fromEntityToDto(repository.findMe());
    }
}
