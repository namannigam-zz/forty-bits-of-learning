package edu.forty.bits.ps.competitive.anzen;

import java.util.Scanner;

/**
 * Find the maximum from the length of subsets of an array with average less than K
 */
public class HighestAverageUsingDynamicProgramming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] set = java.util.stream.IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
        int Q = scanner.nextInt();
        for (int j = 0; j < Q; j++) {
            int K = scanner.nextInt();
        }
    }
}
