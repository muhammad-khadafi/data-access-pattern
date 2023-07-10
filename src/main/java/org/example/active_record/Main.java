package org.example.active_record;

/**
 * @author muhammad.khadafi
 */
public class Main {
    public static void main(String[] args) {
        // Mencari person berdasarkan ID
        Person person = Person.findById(1);
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
        newPerson.insert();
        System.out.println("New person inserted successfully.");

        // Menghapus data person
        person = Person.findById(2);
        if (person != null) {
            person.delete();
            System.out.println("Person deleted successfully.");
        }
    }
}
