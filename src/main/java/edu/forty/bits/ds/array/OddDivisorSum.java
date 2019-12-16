package edu.forty.bits.ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class OddDivisorSum {

    private static int count(int[] numbers) {
        return Arrays.stream(numbers).map(OddDivisorSum::oddDivisorSum).sum();
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
}
