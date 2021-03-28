package br.com.rodrigogmartins.restwithspringboot.controllers;

import br.com.rodrigogmartins.restwithspringboot.models.Person;
import br.com.rodrigogmartins.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService services;

    @GetMapping
    public List<Person> findAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") String id) {
        return services.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") String id) {
        services.remove(id);

        return ResponseEntity.ok().build();
    }
}
