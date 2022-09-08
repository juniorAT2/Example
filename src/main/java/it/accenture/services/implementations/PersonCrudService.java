package it.accenture.services.implementations;

import it.accenture.model.Person;
import it.accenture.repositories.abstractions.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonCrudService extends CrudService<Person, Long, PersonRepository> {

    public PersonCrudService(PersonRepository repo) {
        super(repo, Person.class);
    }
}