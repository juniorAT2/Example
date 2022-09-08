package it.accenture.services;

import it.accenture.model.Person;
import it.accenture.repositories.JdbcPersonRepository;
import it.accenture.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonCrudService extends CrudService<Person, Long, PersonRepository> {

    public PersonCrudService(PersonRepository repo) {
        super(repo, Person.class);
    }
}