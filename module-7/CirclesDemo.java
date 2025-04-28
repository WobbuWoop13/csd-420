// Kyle Marlia-Conner
// 04/26/2025
// Assignment 7

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CirclesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Circle 1 - white, inside a black rectangle
        Circle circle1 = new Circle(60, 100, 30);
        circle1.getStyleClass().add("plaincircle");

        // The Rectangle around circle 1
        Rectangle rectangle = new Rectangle(20, 10, 80, 180); // taller
        rectangle.setStyle("-fx-stroke: black; -fx-stroke-width: 4; -fx-fill: transparent;");

        // Circle 2 - white filled
        Circle circle2 = new Circle(140, 100, 30);
        circle2.getStyleClass().add("plaincircle");

        // Circle 3 - red filled
        Circle circle3 = new Circle(220, 100, 30);
        circle3.setId("redcircle");

        // Circle 4 - green filled
        Circle circle4 = new Circle(300, 100, 30);
        circle4.setId("greencircle");

        // Add all shapes to the pane
        pane.getChildren().addAll(rectangle, circle1, circle2, circle3, circle4);

        Scene scene = new Scene(pane, 360, 200);
        scene.getStylesheets().add(getClass().getResource("/mystyle.css").toExternalForm());

        primaryStage.setTitle("Four Circles Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Test Section (I believe this covers the basis for the objects and flags if something changes)
        System.out.println("Running Tests");

        assert circle1.getStyleClass().contains("plaincircle") : "Circle1 should have class 'plaincircle'";
        assert circle2.getStyleClass().contains("plaincircle") : "Circle2 should have class 'plaincircle'";
        assert "redcircle".equals(circle3.getId()) : "Circle3 should have ID 'redcircle'";
        assert "greencircle".equals(circle4.getId()) : "Circle4 should have ID 'greencircle'";
        assert rectangle.getHeight() == 180 : "Rectangle should be 180 tall";
        assert rectangle.getY() == 10 : "Rectangle should start at y=10";

        System.out.println("All tests passed successfully!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
