package org.practice.learning.sorting;

/**
 * Time Complexity : O(nLogn)
 *
 * Space complexity : O(1)
 *
 * Quick Sort in its general form is an in-place sort (i.e. it doesn't require any extra storage)
 * whereas merge sort requires O(N) extra storage
 *
 * Although the worst case time complexity of QuickSort is O(n2) which is more than many other sorting algorithms
 * like Merge Sort and Heap Sort, QuickSort is faster in practice,
 * because its inner loop can be efficiently implemented on most architectures, and in most real-world data
 */
class QuickSort {

    /* This function takes last element as pivot,
      places the pivot element at its correct
      position in sorted array, and places all
      smaller (smaller than pivot) to left of
      pivot and all greater elements to right
      of pivot */
    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The convertNumbersToName function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively quickSort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    /* This QuickSort requires O(Log n) auxiliary space in worst case. */
    static void quickSortWithTailCallOptimisation(int arr[], int low, int high) {
        while (low < high) {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            // If left part is smaller, then recur for left
            // part and handle right part iteratively
            if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            }

            // Else recur for right part
            else {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }
}