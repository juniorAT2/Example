package it.accenture.controllers;

import it.accenture.model.Person;
import it.accenture.services.PersonCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonCrudService crudService;
    @Autowired
    public PersonController(PersonCrudService crudService) {
        this.crudService = crudService;
    }
    @GetMapping("/")
    public List<Person> getAll() {
        return crudService.getAll();
    }
    @PostMapping("/")
    public String addPerson(@RequestBody Person person) {
        return crudService.addPerson(person);
    }
    @PutMapping("/")
    public String updatePerson (@RequestBody Person person) {
        return crudService.updatePerson(person);
    }
    @DeleteMapping("/{id}")
    public String deletePerson (@PathVariable("id") Long personId) {
        return crudService.deletePerson(personId);
    }
}