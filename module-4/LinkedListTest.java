// Kyle Marlia-Conner
// 04/06/2025
// Assignment 4

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTest {

    public static void main(String[] args) {
        System.out.println("Testing with 50,000 elements:");
        testTraversalTimes(50000);

        System.out.println("\nTesting with 500,000 elements:");
        testTraversalTimes(500000);
    }

    public static void testTraversalTimes(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Traverse with Iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Iterator traversal time: " + iteratorTime + " ns");

        // Traverse with get(index)
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getIndexTime = endTime - startTime;
        System.out.println("get(index) traversal time: " + getIndexTime + " ns");

        // Test correctness (basic check)
        if (list.get(0) == 0 && list.get(list.size() - 1) == size - 1) {
            System.out.println("Basic list check passed.");
        } else {
            System.out.println("List data issue.");
        }

        // Comments explaining performance of the two.
        System.out.println("Just a Note!");
        System.out.println("Iterator is much faster for LinkedList because it traverses sequentially.");
        System.out.println("get(index) is slow because LinkedList must start from the beginning each time.");
    }
}
