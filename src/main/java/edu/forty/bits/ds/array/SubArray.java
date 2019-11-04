package edu.forty.bits.ds.array;

import java.util.Arrays;

public class SubArray {

  private static int findSubArray(int[] a, int k) {
    int curr_sum, i, j;
    for (i = 0; i < a.length; i++) {
      curr_sum = a[i];
      for (j = i + 1; j <= a.length; j++) {
        if (curr_sum == k) {
          int p = j - 1;
          return (p - i + 1);
        }
        if (curr_sum > k || j == a.length) break;
        curr_sum = curr_sum + a[j];
      }
    }
    return 0;
  }

  static int maxSum(int[] a) {
    return Arrays.stream(a).sum();
  }

  public static void main(String[] args) {
    int[] arrA = {1, 2, 3};
    int sum = 3;
    System.out.println(findSubArray(arrA, sum));
  }

  int subArraySum(int[] arr, int n, int sum) {
    int curr_sum = arr[0], start = 0, i;

    // Pick a starting point
    for (i = 1; i <= n; i++) {
      // If curr_sum exceeds the sum, then remove the starting elements
      while (curr_sum > sum && start < i - 1) {
        curr_sum = curr_sum - arr[start];
        start++;
      }

      // If curr_sum becomes equal to sum, then return true
      if (curr_sum == sum) {
        int p = i - 1;
        System.out.println("Sum found between indexes " + start + " and " + p);
        return 1;
      }

      // Add this element to curr_sum
      if (i < n) curr_sum = curr_sum + arr[i];
    }

    System.out.println("No subarray found");
    return 0;
  }
}
