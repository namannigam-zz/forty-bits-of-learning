package edu.forty.bits.ps.competitive.microsoft;

import java.util.Arrays;
import java.util.Scanner;

public class SubArraySumSolution {

    private static int count(int[] numbers) {
        return Arrays.stream(numbers).map(SubArraySumSolution::oddDivisorSum).sum();
    }

    private static int oddDivisorSum(int number) {
        int maxDivisor = number / 2;
        int oddSum = 1;
        for (int i = 3; i <= maxDivisor; i += 2) {
            if (number % i == 0) {
                oddSum += i;
            }
        }
        return oddSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _numbers_size;
        _numbers_size = Integer.parseInt(in.nextLine().trim());
        int[] _numbers = new int[_numbers_size];
        int _numbers_item;
        for (int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
            _numbers_item = Integer.parseInt(in.nextLine().trim());
            _numbers[_numbers_i] = _numbers_item;
        }

        System.out.println(count(_numbers));
    }

    int subArraySum(int arr[], int n, int sum) {
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
