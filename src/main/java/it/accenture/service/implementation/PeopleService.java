package it.accenture.service.implementation;


import it.accenture.repository.PeopleRepository;
import it.accenture.service.abstraction.AbstractPeopleService;
import org.springframework.stereotype.Service;



@Service
public class PeopleService implements AbstractPeopleService {
    private PeopleRepository peopleRepo;
    public PeopleService (PeopleRepository pr) {
        this.peopleRepo = pr;
    }
}
