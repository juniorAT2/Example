package it.accenture.services;

import it.accenture.model.Person;
import it.accenture.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCrudService {
    private PersonRepository personRepository;
    @Autowired
    public PersonCrudService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public String addPerson(Person person) {
        String response = null;
        if(personRepository.addPerson(person)){
            response = "Successfully Added";
        }
        else {
            response = "Somthing went wrong. Not added, please try again.";
        }
        return response;
    }
    public String updatePerson(Person person) {
        String response = null;
        if(personRepository.updatePerson(person)){
            response = "Successfully Updated";
        }
        else {
            response = "Somthing went wrong. Not updated, please try again.";
        }
        return response;
    }
    public String deletePerson(Long personId) {
        String response = null;
        if(personRepository.deletePerson(personId)){
            response = "Successfully Delete";
        }
        else {
            response = "Somthing went wrong. Not deleted, please try again.";
        }
        return response;
    }
}