package org.example.data_access_object;

/**
 * @author muhammad.khadafi
 */
public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAOImpl();
        PersonService personService = new PersonService(personDAO);

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        personService.insertPerson(person);
    }
}

