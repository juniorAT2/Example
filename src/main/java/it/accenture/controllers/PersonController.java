package it.accenture.controllers;

import it.accenture.dtos.PersonDTO;
import it.accenture.exceptions.EntityNotFoundException;
import it.accenture.mapstruct.PersonMapper;
import it.accenture.model.Person;
import it.accenture.services.implementations.PersonCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonCrudService crudService;
    //private AbstractCrudService<Classroom, Long> crudService;

    @Autowired
    public PersonController(PersonCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonDTO>> getAll() {
        var cls = crudService.getAll();
        var dtos = StreamSupport.stream(cls.spliterator(), false)
                .map(PersonMapper.INSTANCE::fromPerson).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable long id) {
        Optional<Person> optClass = crudService.findById(id);
        if (optClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optClass.map(PersonMapper.INSTANCE::fromPerson).get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            crudService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonDTO pDto) {
        Person p = PersonMapper.INSTANCE.toPerson(pDto);
        try {
            Person pSaved = crudService.saveOrUpdate(p);
            PersonDTO dto = PersonMapper.INSTANCE.fromPerson(p);
            URI uri = new URI("jdbc:h2:file:./data/fileDB/" + dto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody PersonDTO pDto, @PathVariable long id) {
        Person p = PersonMapper.INSTANCE.toPerson(pDto);
        try {
            Person pSaved = crudService.saveOrUpdate(p);
            PersonDTO dto = PersonMapper.INSTANCE.fromPerson(p);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}