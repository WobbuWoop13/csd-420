// Kyle Marlia-Conner
// 04/05/2025
// Assignment 3

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Fill the original list with 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1); // Restricting between 1 and 20
        }

        // Print the original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Get the new list without duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        // Print the new list without duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicates);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
