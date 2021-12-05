package com.example.endofgame.repository;

import com.example.endofgame.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class PersonRepository {

    // The line below is the same as using @Slf4j annotation
//    private static Logger log = LoggerFactory.getLogger(PersonRepository.class);

    public Person findMe() {
        log.info("findMe()");
        return new Person("Mariusz", "P.");
    }
}
