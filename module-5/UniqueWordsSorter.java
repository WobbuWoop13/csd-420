// Kyle Marlia-Conner
// 04/13/25
// Assignment 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueWordsSorter {
    public static void main(String[] args) {
        Set<String> uniqueWords = new TreeSet<>(); // TreeSet auto-sorts in ascending order

        try {
            File wordFile = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(wordFile);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", ""); // Clean non-letters
                if (!word.isEmpty()) {
                    uniqueWords.add(word);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        // Display in ascending order
        System.out.println("Non-duplicate words in ASCENDING order:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        // Display in descending order
        System.out.println("\nNon-duplicate words in DESCENDING order:");
        List<String> descendingList = new ArrayList<>(uniqueWords);
        Collections.reverse(descendingList);
        for (String word : descendingList) {
            System.out.println(word);
        }
    }
}
