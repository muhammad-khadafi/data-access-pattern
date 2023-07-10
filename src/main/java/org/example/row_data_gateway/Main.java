package org.example.row_data_gateway;

/**
 * @author muhammad.khadafi
 */
public class Main {
    public static void main(String[] args) {
        // Mencari person berdasarkan ID
        PersonFinder personFinder = new PersonFinder();
        PersonRowDataGateway person = personFinder.findById(1);
        if (person != null) {
            System.out.println("Person found by ID:");
            System.out.println("ID: " + person.getId());
            System.out.println("First Name: " + person.getFirstName());
            System.out.println("Last Name: " + person.getLastName());
            System.out.println("Number of Dependents: " + person.getNumberOfDependents());
        } else {
            System.out.println("Person not found by ID.");
        }

        // Mencari person berdasarkan first name
        person = personFinder.findByFirstName("John");
        if (person != null) {
            System.out.println("\nPerson found by First Name:");
            System.out.println("ID: " + person.getId());
            System.out.println("First Name: " + person.getFirstName());
            System.out.println("Last Name: " + person.getLastName());
            System.out.println("Number of Dependents: " + person.getNumberOfDependents());
        } else {
            System.out.println("\nPerson not found by First Name.");
        }

        // Menambahkan data person baru
        PersonRowDataGateway newPerson = new PersonRowDataGateway();
        newPerson.setFirstName("Jane");
        newPerson.setLastName("Doe");
        newPerson.setNumberOfDependents(2);
        newPerson.insert();
        System.out.println("\nNew person inserted successfully.");
    }
}

