package edu.forty.bits.datastructures.sorting;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2)
 *
 * <p>Auxiliary Space: O(1)
 *
 * <p>Insertion heapSort takes maximum time to sort if elements are sorted in reverse order. And it
 * takes minimum time (Order of n) when elements are already sorted.
 *
 * <p>Insertion heapSort is used when number of elements is small. It can also be useful when input
 * array is almost sorted, only few elements are misplaced in complete big array
 */
class InsertionSort {

    /* Function to heapSort array using insertion heapSort */
    static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

      /* Move elements of arr[0..i-1], that are
      greater than key, to one position ahead
      of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Binary Insertion Sort find use binary search to find the proper location to insert the selected
     * item at each iteration. In normal insertion, heapSort it takes O(i) (at ith iteration) in worst
     * case. We can reduce it to O(logi) by using binary search.
     */
    static void binaryInsertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];

            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            // Shifting array to one location right
            System.arraycopy(array, j, array, j + 1, i - j);

            // Placing element at its correct location
            array[j] = x;
        }
    }
}
