package br.com.rodrigogmartins.restwithspringboot.valueobjects;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private byte age;

    public PersonVO() {  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVO = (PersonVO) o;
        return age == personVO.age && Objects.equals(id, personVO.id) && firstName.equals(personVO.firstName) && lastName.equals(personVO.lastName) && email.equals(personVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, age);
    }
}
