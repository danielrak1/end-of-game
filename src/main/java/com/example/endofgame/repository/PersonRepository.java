package com.example.endofgame.repository;

import com.example.endofgame.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class PersonRepository {

    public Person findMe(){
        log.info("findMe()");
        return new Person("Daniel", "Rak" );
    }
}
