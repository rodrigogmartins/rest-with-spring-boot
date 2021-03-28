package br.com.rodrigogmartins.restwithspringboot.builders;

import br.com.rodrigogmartins.restwithspringboot.models.Person;

public class PersonBuilder {

    private String id = "";
    private String firstName;
    private String lastName;
    private String email;
    private byte age;

    public PersonBuilder() { }

    public Person build() {
        Person person = new Person();
        person.setId(this.id);
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setEmail(this.email);
        person.setAge(this.age);

        return person;
    }

    public PersonBuilder id(String id)  {
        this.id = id;

        return this;
    }

    public PersonBuilder firstName(String firstName)  {
        this.firstName = firstName;

        return this;
    }

    public PersonBuilder lastName(String lastName)  {
        this.lastName = lastName;

        return this;
    }

    public PersonBuilder email(String email)  {
        this.email = email;

        return this;
    }

    public PersonBuilder age(int age)  {
        this.age = (byte) age;

        return this;
    }

}
