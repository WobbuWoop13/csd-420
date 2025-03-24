// Kyle Marlia-Conner
// 03/23/25
// Assignment 1.3

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class CardAssignment extends Application {
    private static final int NUM_CARDS = 52;
    private static final int DISPLAY_COUNT = 4;
    private static final String CARD_PATH = "cards/";
    private static final String EXTENSION = ".png";
    
    private List<Integer> cardNumbers = new ArrayList<>();
    private ImageView[] cardViews = new ImageView[DISPLAY_COUNT];
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize card numbers
        for (int i = 1; i <= NUM_CARDS; i++) {
            cardNumbers.add(i);
        }
        
        // Create ImageViews for displaying cards
        HBox cardBox = new HBox(10);
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitHeight(150);
            cardViews[i].setPreserveRatio(true);
            cardBox.getChildren().add(cardViews[i]);
        }
        
        // Refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> updateCards());
        
        VBox root = new VBox(10, cardBox, refreshButton);
        
        // Initial card display
        updateCards();
        
        // Set up the stage
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
    
    private void updateCards() {
        Collections.shuffle(cardNumbers);
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            String imagePath = "file:/C:/Users/kylec/Documents/NetBeansProjects/CardAssignment/src/cards/" + cardNumbers.get(i) + EXTENSION;
            cardViews[i].setImage(new Image(imagePath));
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
