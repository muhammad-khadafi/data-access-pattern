package org.example.data_access_object;

/**
 * @author muhammad.khadafi
 */
public class PersonService {

    PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void insertPerson(Person person){
        // some process ...
        // some process ...

        personDAO.insert(person);

    }
}
