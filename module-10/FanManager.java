// Kyle Marlia-Conner
// 05/10/2025
// Assignment 10

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class FanManager extends Application {

    
    // UI input fields for data
    private TextField idField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField favoriteTeamField = new TextField();

    // Database connection
    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String USER = "student1";
    private final String PASS = "pass";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        // Grid layout/labels/inputs and buttons
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);

        grid.add(new Label("Favorite Team:"), 0, 3);
        grid.add(favoriteTeamField, 1, 3);

        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

        // Add action to display fan info by ID when button is clicked
        displayButton.setOnAction(e -> displayFan());
        // Add action to update fan info with entered values
        updateButton.setOnAction(e -> updateFan());

        grid.add(displayButton, 0, 4);
        grid.add(updateButton, 1, 4);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fan Manager");
        primaryStage.show();
    }

    // Retrieves fan data based on ID entered
    private void displayFan() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                showAlert("No fan found with that ID.");
            }
        } catch (Exception ex) {
            showAlert("Error: " + ex.getMessage());
        }
    }

    // Updates fan record with new input
    private void updateFan() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, favoriteTeamField.getText());
            stmt.setInt(4, Integer.parseInt(idField.getText()));

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Update successful!");
            } else {
                showAlert("Update failed. ID not found.");
            }
        } catch (Exception ex) {
            showAlert("Error: " + ex.getMessage());
        }
    }

    // Displays the dialog box
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }
}
