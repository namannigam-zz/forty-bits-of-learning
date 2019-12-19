package edu.forty.bits.datastructures.array;

import java.util.Arrays;

/**
 * Created by naman.nigam on 09/02/16.
 */
public class TripletSum {

    private static void printTriplets(int[] arr, int n, int sum) {
        // Sort input array
        Arrays.sort(arr);

        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (int i = 0; i < n - 2; i++) {

            // Initialize other two elements as corner
            // elements of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] > sum) {
                    k--;
                }
                // Else move left corner
                else if (arr[i] + arr[j] + arr[k] < sum) {
                    j++;
                } else {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                    break;
                }
            }
        }
    }

    // Driver program
    public static void main(String[] args) {
        int arr[] = {0, 5, 1, 3, 4, 7, 8, 9};
        int n = arr.length;
        int sum = 13;
        printTriplets(arr, n, sum);
    }
}
