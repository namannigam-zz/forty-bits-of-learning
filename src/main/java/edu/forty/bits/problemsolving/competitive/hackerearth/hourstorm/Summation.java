package edu.forty.bits.problemsolving.competitive.hackerearth.hourstorm;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Summation {

    private static final int MODULO = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Integer> values =
                IntStream.range(0, N).mapToObj(a -> scanner.nextInt()).collect(Collectors.toList());
        for (int i = 1; i <= K; i++) {
            int sum = 0;
            for (int j = 0; j <= N; j++) {
                for (int k = j; k <= N; k++) {
                    sum += functionOfI(sumOfRange(values, j, k), i);
                }
            }
            System.out.print(sum + " ");
        }
    }

    private static int functionOfI(long val, int i) {
        return (int) Math.pow(val, i);
    }

    private static int sumOfRange(List<Integer> values, int l, int r) {
        return IntStream.rangeClosed(l, r).map(values::get).sum() % MODULO;
    }
}
