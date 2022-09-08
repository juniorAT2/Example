package it.accenture.services;

import it.accenture.model.Person;
import it.accenture.repositories.JdbcPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonCrudService extends CrudService<Person, Long, JdbcPersonRepository> {

    public PersonCrudService(JdbcPersonRepository repo) {
        super(repo, Person.class);
    }
}