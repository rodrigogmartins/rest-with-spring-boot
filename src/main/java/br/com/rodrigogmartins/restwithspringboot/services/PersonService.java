package br.com.rodrigogmartins.restwithspringboot.services;

import br.com.rodrigogmartins.restwithspringboot.classes.IdGenerator;
import br.com.rodrigogmartins.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.rodrigogmartins.restwithspringboot.models.Person;
import br.com.rodrigogmartins.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        person.setId(IdGenerator.generateId());

        return repository.save(person);
    }

    public Person update(Person person) {
        Person entity = this.findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setEmail(person.getEmail());
        entity.setAge(person.getAge());

        return repository.save(person);
    }

    public void remove(String id) {
        Person person = this.findById(id);

        repository.delete(person);
    }

    public Person findById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

}
