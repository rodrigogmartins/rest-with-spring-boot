package br.com.rodrigogmartins.restwithspringboot.services;

import br.com.rodrigogmartins.restwithspringboot.classes.IdGenerator;
import br.com.rodrigogmartins.restwithspringboot.converters.DozerConverter;
import br.com.rodrigogmartins.restwithspringboot.data.models.Person;
import br.com.rodrigogmartins.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.rodrigogmartins.restwithspringboot.repositories.PersonRepository;
import br.com.rodrigogmartins.restwithspringboot.valueobjects.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        entity.setId(IdGenerator.generateId());

        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        Person entity = this.findEntityById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setEmail(person.getEmail());
        entity.setAge(person.getAge());

        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public void remove(String id) {
        Person person = this.findEntityById(id);

        repository.delete(person);
    }

    public PersonVO findById(String id) {
        return DozerConverter.parseObject(this.findEntityById(id), PersonVO.class);
    }

    private Person findEntityById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseObjectsList(repository.findAll(), PersonVO.class);
    }

}
