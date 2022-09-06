package it.accenture.controller;


import it.accenture.service.abstraction.AbstractPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/person")
public class PeopleController {

    private AbstractPeopleService aps;
    @Autowired
    public PeopleController (AbstractPeopleService aps) {
        this.aps = aps;
    }
}
