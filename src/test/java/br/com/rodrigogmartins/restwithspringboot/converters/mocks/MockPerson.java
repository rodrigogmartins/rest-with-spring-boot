package br.com.rodrigogmartins.restwithspringboot.converters.mocks;

import br.com.rodrigogmartins.restwithspringboot.data.models.Person;
import br.com.rodrigogmartins.restwithspringboot.valueobjects.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }

        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }

        return persons;
    }

    private Person mockEntity(Integer number) {
        Person person = new Person();
        person.setFirstName("First Name Test " + number);
        person.setLastName("Last Name Test " + number);
        person.setEmail(number + "testmail@example.com");
        person.setAge((byte) (20 + number));

        return person;
    }

    private PersonVO mockVO(Integer number) {
        PersonVO personVO = new PersonVO();
        personVO.setFirstName("First Name Test " + number);
        personVO.setLastName("Last Name Test " + number);
        personVO.setEmail(number + "testmail@example.com");
        personVO.setAge((byte) (20 + number));

        return personVO;
    }
}
