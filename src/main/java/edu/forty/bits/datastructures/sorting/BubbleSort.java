package edu.forty.bits.datastructures.sorting;

import java.util.stream.IntStream;

/**
 * Time Complexity: O(n^2). Worst case occurs when array is reverse sorted O(n). Best case occurs
 * when array is already sorted.
 *
 * <p>Auxiliary Space: O(1)
 *
 * <p>Used in practice to heapSort almost sorted array with complexity of 2n e.g. polygon filling
 * algorithm
 */
class BubbleSort {

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        // swap temp and arr[i]
        IntStream.range(0, n - 1)
                .forEach(
                        i ->
                                IntStream.range(0, n - i - 1)
                                        .filter(j -> arr[j] > arr[j + 1])
                                        .forEach(
                                                j -> {
                                                    int temp = arr[j];
                                                    arr[j] = arr[j + 1];
                                                    arr[j + 1] = temp;
                                                }));
    }

    // An optimized version of Bubble Sort
    static void optimisedBubbleSort(int arr[]) {
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}
