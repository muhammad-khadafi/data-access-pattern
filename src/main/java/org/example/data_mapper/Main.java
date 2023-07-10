package org.example.data_mapper;

/**
 * @author muhammad.khadafi
 */
public class Main {
    public static void main(String[] args) {
        // Mencari person berdasarkan ID
        PersonMapper personMapper = Person.getMapper();
        Person findingPerson = new Person();
        findingPerson.setId(1);
        Person person = personMapper.findById(findingPerson);
        if (person != null) {
            System.out.println("Person found by ID:");
            System.out.println("ID: " + person.getId());
            System.out.println("First Name: " + person.getFirstName());
            System.out.println("Last Name: " + person.getLastName());
            System.out.println("Number of Dependents: " + person.getNumberOfDependents());
        } else {
            System.out.println("Person not found by ID.");
        }

        // Menambahkan data person baru
        Person newPerson = new Person();
        newPerson.setFirstName("Jane");
        newPerson.setLastName("Doe");
        newPerson.setNumberOfDependents(2);
        personMapper.insert(newPerson);
        System.out.println("New person inserted successfully.");

        // Mengupdate data person
        person = personMapper.findById(newPerson);
        if (person != null) {
            person.setNumberOfDependents(3);
            personMapper.update(person);
            System.out.println("Person updated successfully.");
        }
    }
}
