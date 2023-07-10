package org.example.data_access_object;

import java.sql.*;

/**
 * @author muhammad.khadafi
 */
public class PersonDAOImpl implements PersonDAO {
    private Connection getConnection() throws SQLException {
        // Code to establish and return a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        return connection;
    }


    @Override
    public Person findById(int id) {
        // Retrieve data from the database and map it to a Person object

        Person result = null;
        String sql = "SELECT * FROM person WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createPersonFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Person person) {
        // Insert a Person object into the database
    }

    @Override
    public void update(Person person) {
        // Update a Person object in the database
    }

    @Override
    public void delete(int id) {
        // Delete a Person object from the database by ID
    }

    private Person createPersonFromResultSet(ResultSet resultSet) throws SQLException {
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