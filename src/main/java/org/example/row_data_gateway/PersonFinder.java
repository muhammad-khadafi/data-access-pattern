package org.example.row_data_gateway;

/**
 * @author muhammad.khadafi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonFinder {
    public PersonRowDataGateway findById(int id) {
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

    public PersonRowDataGateway findByFirstName(String firstName) {
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

    // Additional finder methods...

    private PersonRowDataGateway createPersonFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int numberOfDependents = resultSet.getInt("number_of_dependents");

        PersonRowDataGateway person = new PersonRowDataGateway();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setNumberOfDependents(numberOfDependents);

        return person;
    }
}

