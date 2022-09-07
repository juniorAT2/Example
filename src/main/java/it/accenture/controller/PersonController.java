package it.accenture.controller;


import it.accenture.service.abstraction.AbstractPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/person")
public class PersonController {
    private AbstractPersonService aps;
    @Autowired
    public PersonController(AbstractPersonService aps) {
        this.aps = aps;
    }
}
