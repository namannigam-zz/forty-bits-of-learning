package edu.forty.bits.problemsolving.competitive.microsoft;

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
}
