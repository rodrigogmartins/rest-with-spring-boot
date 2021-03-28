package br.com.rodrigogmartins.restwithspringboot.controllers;

import br.com.rodrigogmartins.restwithspringboot.services.PersonService;
import br.com.rodrigogmartins.restwithspringboot.valueobjects.PersonVO;
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
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable(value = "id") String id) {
        return services.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") String id) {
        services.remove(id);

        return ResponseEntity.ok().build();
    }
}
