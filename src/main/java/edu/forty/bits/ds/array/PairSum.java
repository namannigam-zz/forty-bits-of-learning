package org.practice.learning.array;

import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Auxiliary Space: O(n) where n is size of array
 */
public class PairSum {
    private static void printPairs(int[] arr, int sum) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];
            // checking for condition
            if (temp >= 0 && s.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
            }
            s.add(arr[i]);
        }
    }
}