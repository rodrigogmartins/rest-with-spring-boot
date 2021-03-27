package br.com.rodrigogmartins.restwithspringboot.services;

import br.com.rodrigogmartins.restwithspringboot.builders.PersonBuilder;
import br.com.rodrigogmartins.restwithspringboot.classes.IdGenerator;
import br.com.rodrigogmartins.restwithspringboot.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public Person create(Person person) {
        person.setId(IdGenerator.generateId());

        return person;
    }

    public Person update(Person person) {
        person.setEmail("outroemail@gmail.com");

        return person;
    }

    public void remove(String id) {
    }

    public Person findById(String id) {
        Person person = new PersonBuilder()
                            .id(IdGenerator.generateId())
                            .firstName("Rodrigo")
                            .lastName("Gaspar Martins")
                            .email("rodrigo@gmail.com")
                            .age(20)
                            .build();

        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new PersonBuilder()
                .id(IdGenerator.generateId())
                .firstName(i + " - Rodrigo")
                .lastName("Gaspar Martins")
                .email("rodrigo@gmail.com")
                .age(20)
                .build();

        return person;
    }
}
