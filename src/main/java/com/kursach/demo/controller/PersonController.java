package com.kursach.demo.controller;

import com.kursach.demo.dto.PersonDTO;
import com.kursach.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.ssau.study.dto.CommitteeDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/{comName}")
    public PersonDTO createPerson( @PathVariable String comName, @RequestBody PersonDTO personDTO) {
        return personService.createPerson(comName, personDTO);
    }

    @GetMapping("/{name}")
    public List<PersonDTO> findAllByName(@PathVariable String name) {
        return personService.findAAllByName(name);
    }

    @GetMapping
    public List<PersonDTO> findAllPeople() {
        return personService.findAllPeople();
    }
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id){
        personService.deletePersonById(id);
    }

    @PutMapping("/{id}")
    public PersonDTO editPerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return personService.editPerson(id, personDTO);
    }

}





