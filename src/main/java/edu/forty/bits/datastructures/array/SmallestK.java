package edu.forty.bits.datastructures.array;


import edu.forty.bits.datastructures.annotations.Array;
import edu.forty.bits.datastructures.annotations.Tree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

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
    public static int[] smallestKSelectionRankingAlgorithm(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        int threshold = rank(array, k - 1);
        int[] smallest = new int[k];
        int count = 0;
        for (int a : array) {
            if (a <= threshold) {
                smallest[count] = a;
                count++;
            }
        }
        return smallest;
    }

    /* Get item with rank. */
    public static int rank(int[] array, int rank) {
        return rank(array, 0, array.length - 1, rank);
    }

    /* Get element with rank between left and right indices. */
    public static int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntInRange(left, right)];
        int leftEnd = partition(array, left, right, pivot); // returns end of left partition
        int leftSize = leftEnd - left + 1;
        if (rank == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        } else {
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    /* Partition array around pivot such that all elements <= pivot
     * come before all elements > pivot. */
    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {
                /* Left is bigger than pivot. Swap it to the right side, where we know it should be. */
                swap(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
                /* Right is smaller than the pivot. Swap it to the left side, where we know it should be. */
                swap(array, left, right);
                left++;
            } else {
                /* Left and right are in correct places. Expand both sides. */
                left++;
                right--;
            }
        }
        return left - 1;
    }

    /* Get random integer within range, inclusive. */
    public static int randomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1 - min) + min;
    }

    /* Swap values at index i and j. */
    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /* Get largest element in array between left and right indices. */
    public static int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }


    // Approach 4: Selection ranking algorithm with non unique elements
    public static class PartitionResult {
        int leftSize;
        int middleSize;

        public PartitionResult(int left, int middle) {
            this.leftSize = left;
            this.middleSize = middle;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15};
        int[] smallest = smallestK(array, 3);
        System.out.println(Arrays.toString(smallest));
        smallest = smallestKMaxHeap(array, 3);
        System.out.println(Arrays.toString(smallest));
        smallest = smallestKSelectionRankingAlgorithm(array, 3);
        System.out.println(Arrays.toString(smallest));
    }
}