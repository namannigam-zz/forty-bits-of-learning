package edu.forty.bits.datastructures.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as
 * new values are generated.
 */
public class ContinuousMean {

    // Create a binary search tree such that root is always the median
    // Details in terms of odd number of elements and even number of elements would help in deciding the approach

    // Instead of a tree, using min and max heap for different buckets of elements can help identify the median easily


    // Comparator that sorts integers from highest to lowest
    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    }

    // Comparator that sorts integers from highest to lowest
    static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }


    private static Comparator<Integer> maxHeapComparator;
    private static Comparator<Integer> minHeapComparator;
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void addNewNumber(int randomNumber) {
        /* Note: addNewNumber maintains a condition that maxHeap.size() >= minHeap.size() */
        if (maxHeap.size() == minHeap.size()) {
            if ((minHeap.peek() != null) &&
                    randomNumber > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            } else {
                maxHeap.offer(randomNumber);
            }
        } else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            } else {
                minHeap.offer(randomNumber);
            }
        }
    }

    public static double getMedian() {
        /* maxHeap is always at least as big as minHeap. So if maxHeap is empty, then minHeap is also. */
        if (maxHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            /* If maxHeap and minHeap are of different sizes, then maxHeap must have one extra element. Return maxHeap�s top element.*/
            return maxHeap.peek();
        }
    }

    public static void addNewNumberAndPrintMedian(int randomNumber) {
        addNewNumber(randomNumber);
        System.out.println("Random Number = " + randomNumber);
        printMinHeapAndMaxHeap();
        System.out.println("Median = " + getMedian() + "\n");
    }

    public static void printMinHeapAndMaxHeap() {
        Integer[] minHeapArray = minHeap.toArray(new Integer[0]);
        Integer[] maxHeapArray = maxHeap.toArray(new Integer[0]);
        Arrays.sort(minHeapArray, minHeapComparator);
        Arrays.sort(maxHeapArray, maxHeapComparator);
        System.out.print("MinHeap =");
        for (int i = minHeapArray.length - 1; i >= 0; i--) {
            System.out.print(" " + minHeapArray[i]);
        }
        System.out.print("\nMaxHeap =");
        for (Integer integer : maxHeapArray) {
            System.out.print(" " + integer);
        }
    }

    public static void main(String[] args) {
        int arraySize = 10;
        int range = 7;
        maxHeapComparator = new MaxHeapComparator();
        minHeapComparator = new MinHeapComparator();
        maxHeap = new PriorityQueue<>(arraySize - arraySize / 2, maxHeapComparator);
        minHeap = new PriorityQueue<>(arraySize / 2, minHeapComparator);

        for (int i = 0; i < arraySize; i++) {
            int randomNumber = (int) (Math.random() * (range + 1));
            addNewNumberAndPrintMedian(randomNumber);
        }
    }
}