package org.practice.learning.competitive.capillary;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Binary Matrix
 * N numbers were converted into their respective Binary form of M length and arranged in an NxM matrix.
 *
 * Your task is to find the index of row (1 based indexing) which contains the binary number with maximum value. If multiple rows have maximum value then print the row with minimum index.
 *
 * Input:
 *
 * The first line contains two space separated integers N and M, denoting number of rows and number of columns in matrix respectively.
 *
 * Each of the next N lines contains a number in binary form.
 *
 * Output:
 *
 * Print the index of row in a single line.
 */
public class BinaryMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int maxIndex = 0;
        String maxValue = IntStream.range(0, M).mapToObj(i -> "0").collect(Collectors.joining());
        for(int i = 0; i < N; i++) {
            String num = scanner.next();
            if (maxValue.compareTo(num) < 0) {
                maxIndex = i;
                maxValue = num;
            }
        }
        System.out.println(maxIndex + 1);
    }
}