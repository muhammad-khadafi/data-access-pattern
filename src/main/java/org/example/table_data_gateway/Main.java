package org.example.table_data_gateway;

/**
 * @author muhammad.khadafi
 */
public class Main {
    public static void main(String[] args) {
        // Mencari person berdasarkan ID
        PersonGateway personGateway = Person.getGateway();
        Person person = personGateway.findById(1);
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
        personGateway.insert(newPerson);
        System.out.println("New person inserted successfully.");

        // Mengupdate data person
        person = personGateway.findById(3);
        if (person != null) {
            person.setNumberOfDependents(3);
            personGateway.update(person);
            System.out.println("Person updated successfully.");
        }
    }
}
