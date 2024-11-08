package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Userroperations {

    public static void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user ("
                   + "uid INT AUTO_INCREMENT PRIMARY KEY, "
                   + "uname VARCHAR(50) NOT NULL, "
                   + "email VARCHAR(50) NOT NULL UNIQUE, "
                   + "password VARCHAR(50) DEFAULT NULL, "
                   + "phno VARCHAR(15) DEFAULT NULL)";
        
        try (Connection c = connection.getConnection();
             Statement statement = c.createStatement()) {
            
            statement.executeUpdate(sql);
            System.out.println("User table created or already exists.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(String name, String email, String password, String phone) {
        String sql = "INSERT INTO user (uname, email, password, phno) VALUES (?, ?, ?, ?)";
        
        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {
            
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phone);
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error inserting user. Possible duplicate email or missing data.");
            e.printStackTrace();
        }
    }

    public static void readUsers() {
        String sql = "SELECT * FROM user";
        
        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("User Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("uid");
                String name = resultSet.getString("uname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phno");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Password: " + password + ", Phone: " + phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUser(int id, String newName, String newEmail) {
        String sql = "UPDATE user SET uname = ?, email = ? WHERE uid = ?";
        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE uid = ?";
        
        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User with ID " + id + " was deleted successfully.");
            } else {
                System.out.println("No user found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        createUserTable();
        deleteUser(13);
        insertUser("Atharsha P","atharshap@gmail.com","1426804","8870455742");
        updateUser(2, "Pradeepa Shivani", "sp@gmail.com");
        readUsers();
    }
}
