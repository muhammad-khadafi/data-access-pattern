package org.example.data_mapper;

import java.sql.*;

/**
 * @author muhammad.khadafi
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int numberOfDependents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public static PersonMapper getMapper() {
        return new PersonMapper();
    }

}
