package edu.forty.bits.problemsolving.competitive.hackerearth.circuit.july18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Consider two sets and , let define their sum set . Now given a set , your task is to find two
 * sets and such that .
 *
 * <p>Assumption, . We define the score as: . You are asked to minimize the score.
 *
 * <p>Input
 *
 * <p>The first line contains an integer denoting the number of elements of set .
 *
 * <p>The following line contains space-separated integers denoting the elements of set .
 *
 * <p>Output
 *
 * <p>Output four lines:
 *
 * <p>The first line contains an integer , the number of elements of set . The second line contains
 * space-separated integers , the elements of set . The third line contains an integer , the number
 * of elements of set . The forth line contains space-separated integers , the elements of set .
 * Constraints
 *
 * <p>. . . Data generation:
 *
 * <p>25% tests: random pick such that . Each number from 1 to has probability in set is . Set is
 * pick from 1 to with the same probability. Then . 25% tests: random pick such that . Each number
 * from 1 to has probability in set is . Set is pick from 1 to with the same probability. Then . 25%
 * tests: each number from 1 to has probability in set C is . 25% tests: each number from 1 to has
 * probability in set C is .
 */
public class HardSumSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        List<Integer> C =
                IntStream.range(0, K)
                        .mapToObj(i -> scanner.nextInt())
                        .sorted()
                        .collect(Collectors.toCollection(() -> new ArrayList<>(K)));
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < C.size(); i++) {
            C.get(i);
        }
    }

    private int score(List<Integer> C, List<Integer> S, int m, int n) {
        int score = 0;
        for (int i = 0; i <= m - n; i++) {
            for (int j = 1; j <= n; j++) {
                score = score + (C.get(j) - S.get(j + 1));
            }
        }
        return score;
    }
}
