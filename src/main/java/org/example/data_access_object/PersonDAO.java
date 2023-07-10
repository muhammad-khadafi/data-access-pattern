package org.example.data_access_object;

/**
 * @author muhammad.khadafi
 */
public interface PersonDAO {
    Person findById(int id);

    void insert(Person person);

    void update(Person person);

    void delete(int id);
}

