// Kyle Marlia-Conner
// 04/27/2025
// Assignment 8

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;
import static javafx.application.Application.launch;

public class KyleThreeThreads extends Application {

    private static final int OUTPUT_SIZE = 10000; // Number of characters per thread
    private static final int BATCH_SIZE = 100; // Add to TextArea in batches instead of single values being added (Hopefully speeds up time)
    private TextArea textArea = new TextArea();

    private int completedThreads = 0; // To track when all threads are done printing their characters

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Kyle's Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the three threads
        startLetterThread();
        startDigitThread();
        startSpecialCharThread();
    }

    private void startLetterThread() {
        Thread letterThread = new Thread(() -> {
            Random random = new Random();
            StringBuilder batch = new StringBuilder();
            for (int i = 0; i < OUTPUT_SIZE; i++) {
                char letter = (char) ('a' + random.nextInt(26));
                batch.append(letter);
                if (batch.length() >= BATCH_SIZE) {
                    String textToAdd = batch.toString();
                    Platform.runLater(() -> textArea.appendText(textToAdd));
                    batch.setLength(0);
                }
            }
            if (batch.length() > 0) { // Handle remaining characters
                String textToAdd = batch.toString();
                Platform.runLater(() -> textArea.appendText(textToAdd));
            }
            System.out.println("Letter thread completed.");
            threadFinished();
        });
        letterThread.start();
    }

    private void startDigitThread() {
        Thread digitThread = new Thread(() -> {
            Random random = new Random();
            StringBuilder batch = new StringBuilder();
            for (int i = 0; i < OUTPUT_SIZE; i++) {
                char digit = (char) ('0' + random.nextInt(10));
                batch.append(digit);
                if (batch.length() >= BATCH_SIZE) {
                    String textToAdd = batch.toString();
                    Platform.runLater(() -> textArea.appendText(textToAdd));
                    batch.setLength(0);
                }
            }
            if (batch.length() > 0) {
                String textToAdd = batch.toString();
                Platform.runLater(() -> textArea.appendText(textToAdd));
            }
            System.out.println("Digit thread completed.");
            threadFinished();
        });
        digitThread.start();
    }

    private void startSpecialCharThread() {
        Thread specialThread = new Thread(() -> {
            Random random = new Random();
            char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
            StringBuilder batch = new StringBuilder();
            for (int i = 0; i < OUTPUT_SIZE; i++) {
                char special = specialChars[random.nextInt(specialChars.length)];
                batch.append(special);
                if (batch.length() >= BATCH_SIZE) {
                    String textToAdd = batch.toString();
                    Platform.runLater(() -> textArea.appendText(textToAdd));
                    batch.setLength(0);
                }
            }
            if (batch.length() > 0) {
                String textToAdd = batch.toString();
                Platform.runLater(() -> textArea.appendText(textToAdd));
            }
            System.out.println("Special character thread completed.");
            threadFinished();
        });
        specialThread.start();
    }

    private synchronized void threadFinished() {
        completedThreads++;
        if (completedThreads == 3) {
            System.out.println("All threads finished successfully!");
            runTests();
        }
    }

    private void runTests() {
        Platform.runLater(() -> {
            String allText = textArea.getText();
            System.out.println("---- Running Tests ----");
            assert allText.length() >= OUTPUT_SIZE * 3 : "Not enough characters output.";
            System.out.println("All tests passed successfully!");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
