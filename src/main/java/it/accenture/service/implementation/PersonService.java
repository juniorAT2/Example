package it.accenture.service.implementation;


import it.accenture.repository.PersonRepository;
import it.accenture.service.abstraction.AbstractPersonService;
import org.springframework.stereotype.Service;



@Service
public class PersonService implements AbstractPersonService {
    private PersonRepository personRepo;


    public PersonService(PersonRepository pr) {
        this.personRepo = pr;
    }
}
