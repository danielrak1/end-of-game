package com.example.endofgame.converter;

import com.example.endofgame.dto.PersonSummary;
import com.example.endofgame.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public PersonSummary fromEntityToDto(Person person) {
        return new PersonSummary(person.getName() + " " + person.getSurname());
    }
}
