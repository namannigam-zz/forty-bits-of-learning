package edu.forty.bits.datastructures.array;


import edu.forty.bits.datastructures.annotations.Array;
import edu.forty.bits.datastructures.annotations.Tree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Design an algorithm to find the smallest K numbers in an array.
 */
@Array
@Tree
public class SmallestK {
    // Approach1: a straight forward way is to sort the array in O(N log(N)) and
    // then find and store the first K numbers in O(K) time

    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        /* Sort array. */
        Arrays.sort(array);

        /* Copy first k elements. */
        int[] smallest = new int[k];
        System.arraycopy(array, 0, smallest, 0, k);
        return smallest;
    }

    // Approach2: another way is to maintain a max heap for the numbers and delete the root for any number smaller than
    // the root. The algorithm is O(N log (K)), where N is total numbers and K is the number of elements we want
    public static int[] smallestKMaxHeap(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> heap = getKMaxHeap(array, k);
        return heapToIntArray(heap);
    }

    /* Convert heap to int array. */
    public static int[] heapToIntArray(PriorityQueue<Integer> heap) {
        int[] array = new int[heap.size()];
        while (!heap.isEmpty()) {
            array[heap.size() - 1] = heap.poll();
        }
        return array;
    }

    /* Create max heap of smallest k elements. */
    public static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));
        for (int a : array) {
            if (heap.size() < k) { // If space remaining
                heap.add(a);
            } else if (a < heap.peek()) { // If full and top is small
                heap.poll(); // remove highest
                heap.add(a); // insert new element
            }
        }
        return heap;
    }

    // Approach3: Selection ranking algorithm

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15};
        int[] smallest = smallestK(array, 3);
        System.out.println(Arrays.toString(smallest));
        smallest = smallestKMaxHeap(array, 3);
        System.out.println(Arrays.toString(smallest));
    }
}