package br.com.rodrigogmartins.restwithspringboot.converters;

import br.com.rodrigogmartins.restwithspringboot.converters.mocks.MockPerson;
import br.com.rodrigogmartins.restwithspringboot.data.models.Person;
import br.com.rodrigogmartins.restwithspringboot.valueobjects.PersonVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DozerConverterTest {

    static MockPerson inputObject;

    @BeforeAll
    public static void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        
        assertEquals("First Name Test 0", output.getFirstName());
        assertEquals("Last Name Test 0", output.getLastName());
        assertEquals("0testmail@example.com", output.getEmail());
        assertEquals(20, output.getAge());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseObjectsList(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputTwelve = outputList.get(12);

        assertEquals("First Name Test 12", outputTwelve.getFirstName());
        assertEquals("Last Name Test 12", outputTwelve.getLastName());
        assertEquals("12testmail@example.com", outputTwelve.getEmail());
        assertEquals(32, outputTwelve.getAge());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);

        assertEquals("First Name Test 0", output.getFirstName());
        assertEquals("Last Name Test 0", output.getLastName());
        assertEquals("0testmail@example.com", output.getEmail());
        assertEquals(20, output.getAge());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseObjectsList(inputObject.mockVOList(), Person.class);
        Person outputSeven = outputList.get(7);

        assertEquals("First Name Test 7", outputSeven.getFirstName());
        assertEquals("Last Name Test 7", outputSeven.getLastName());
        assertEquals("7testmail@example.com", outputSeven.getEmail());
        assertEquals(27, outputSeven.getAge());

    }
}