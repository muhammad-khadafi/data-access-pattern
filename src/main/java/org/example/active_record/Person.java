package org.example.active_record;

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

    public void insert() {
        // Code to save the customer data to the database
    }

    public void update() {
        // Code to update the customer data from the database
    }

    public void delete() {
        // Code to delete the customer data from the database
    }

    public static Person findById(int id) {
        // Code to find person data from the database based on ID
        // and return a new instance of PersonRowDataGateway
        String sql = "SELECT * FROM person WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createPersonFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person findByFirstName(String firstName) {
        // Code to find person data from the database based on first name
        // and return a new instance of PersonRowDataGateway
        String sql = "SELECT * FROM person WHERE first_name = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createPersonFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Person createPersonFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int numberOfDependents = resultSet.getInt("number_of_dependents");

        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setNumberOfDependents(numberOfDependents);

        return person;
    }

}
