package it.accenture.controller;

import it.accenture.dto.PersonDTO;
import it.accenture.mapstruct.PersonMapper;
import it.accenture.model.Person;
import it.accenture.service.implementation.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/person")
public class PersonController {
    @Autowired
    PersonService pService;
    @Autowired
    PersonMapper pMapper;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody PersonDTO pDTO) {
        Person person = pMapper.toPerson(pDTO);
        pService.save(person);
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> findAll() {
        return pMapper.fromPerson(pService.findAll());
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findOne(@PathVariable("id") Long id) {
        return pMapper.fromPerson(pService.findOne(id));
    }
}
