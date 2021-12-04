package com.example.endofgame.service;

import com.example.endofgame.dto.PersonSummary;
import com.example.endofgame.mapping.PersonConverter;
import com.example.endofgame.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    private final PersonConverter personConverter;

    private final ExecutorService workers;

    public PersonService(final PersonRepository repository, final PersonConverter personConverter, ExecutorService workers) {
        this.repository = repository;
        this.personConverter = personConverter;
        this.workers = workers;
    }

    public PersonSummary getMyPerson(){
        log.info("getMyPerson()");
        return personConverter.fromEntityToDto(repository.findMe());
    }

    public void runNewThread() {
        Runnable anotherJob = new Runnable() {
            @Override
            public void run() {
                log.info("inside anonymous class");
                log.info("I'm running by:[" + Thread.currentThread().getName() + "]");
            }
        };
        Runnable newJob = () -> {
            log.info("inside lambda");
            log.info("I'm running by:[" + Thread.currentThread().getName() + "]");
        };

        workers.submit(newJob);
        workers.submit(anotherJob);
    }
}
