package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ArraysAndSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] initialSet = IntStream.range(0, n)
                    .map(x -> scanner.nextInt())
                    .toArray();

            for (int j = 0; j < initialSet.length; j++) {
                int[] remainingSet = removeTheElement(initialSet, j);
                System.out.print(isSubsetSum(remainingSet, remainingSet.length, initialSet[j]) ? "1 " : "0 ");
            }
        }
    }

    static int[] removeTheElement(int[] arr, int index) {
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }

    static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (set[n - 1] > sum) return isSubsetSum(set, n - 1, sum);

        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
}