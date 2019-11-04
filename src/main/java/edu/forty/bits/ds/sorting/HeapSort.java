package edu.forty.bits.ds.sorting;

/**
 * - heapification must be performed in the bottom up order
 *
 * <p>If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and
 * right child by 2 * I + 2 (assuming the indexing starts at 0)
 *
 * <p>Time complexity of heapify is O(Logn). Time complexity of createAndBuildHeap() is O(n) and
 * overall
 *
 * <p>Time complexity: O(nLogn).
 */
class HeapSort {

  static void heapSort(int arr[]) {
    int n = arr.length;

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--) {
      maxHeapify(arr, n, i);
    }

    // One by one extract an element from heap
    for (int i = n - 1; i >= 0; i--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // call max maxHeapify on the reduced heap
      maxHeapify(arr, i, 0);
    }
  }

  // To maxHeapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  private static void maxHeapify(int arr[], int n, int i) {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    // If right child is larger than largest so far
    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    // If largest is not root
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      // Recursively maxHeapify the affected sub-tree
      maxHeapify(arr, n, largest);
    }
  }
}
