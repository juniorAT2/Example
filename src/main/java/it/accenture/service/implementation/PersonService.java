package it.accenture.service.implementation;


import it.accenture.model.Person;
import it.accenture.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    PersonRepository pRepo;

    public void save(Person person) {
        pRepo.save(person);
    }
    public Iterable<Person> findAll() {
        return pRepo.findAll();
    }
    public Optional<Person> findOne (Long id) {
        return pRepo.findById(id);
    }
}
