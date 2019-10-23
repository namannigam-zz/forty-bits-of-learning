package org.practice.learning.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SwapArrayCountSetBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }

        swap_array(_a);

    }

    private static void swap_array(int[] a) {
        Arrays.sort(a);
        int[] countSetBit = new int[10000];
        IntStream.range(0, a.length).forEach(i -> countSetBit[i] = countSetBits(a[i]));
        for (int j = a.length - 1; j >= 0; j--) {
            for (int k = j - 1; k >= 0; k--) {
                if (countSetBit[k] > countSetBit[j]) {
                    int temp = a[k];
                    a[k] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int m = a.length - 1; m >= 0; m--) {
            System.out.println(a[m]);
        }
        // Arrays.stream(a).forEach(System.out::println);
    }


    private static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}