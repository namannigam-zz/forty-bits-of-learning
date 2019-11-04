package edu.forty.bits.ds.sorting;

/**
 * Time Complexity: O(n^2) as there are two nested loops.
 *
 * <p>Auxiliary Space: O(1)
 *
 * <p>The good thing about selection sort is it never makes more than O(n) swaps and can be useful
 * when memory write is a costly operation.
 */
class SelectionSort {

  static void selectionSort(int arr[]) {
    int n = arr.length;

    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n - 1; i++) {
      // Find the minimum element in unsorted array
      int min_idx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }

      // Swap the found minimum element with the first element
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }
}
