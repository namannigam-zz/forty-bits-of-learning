package edu.forty.bits.ps.competitive.hackerearth.circuit.august18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You will be given two arrays A and B of odd length N.
 * In one swap operation, you can select a number from A and another number from B and swap them.
 * You need to find the minimum number of swap operations required so that the median of those two arrays become equal.
 * The median of the array is the element at the middle position in ascending order.
 *
 * Constraints
 *
 * 1 <= T <= 10
 * 1 <= N <= 10^5
 * 0 <= Ai, Bi <= 10^9
 * Note: N will always be an odd number.
 *
 * Input Format
 *
 * The first line contains T, the number of test cases.
 * The first line of a test case contains an integer N.
 * The second line contains N space separated integers representing the array A,
 * and the third line contains N space separated integers representing the array B.
 *
 * Output Format
 *
 * For each test cases, print a single integer,
 * the minimum number of swap operations necessary to make the median of those two arrays equal.
 * If there’s no solution then print “-1”.
 */
public class EqualMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        IntStream.range(0, T).map(i -> scanner.nextInt()).forEach(N -> {
            int medianIndex = N / 2;
            List<Integer> A = IntStream.range(0, N)
                    .mapToObj(j -> scanner.nextInt())
                    .collect(Collectors.toCollection(() -> new ArrayList<>(N)));
            List<Integer> B = IntStream.range(0, N)
                    .mapToObj(j -> scanner.nextInt())
                    .collect(Collectors.toCollection(() -> new ArrayList<>(N)));


        });
    }
}