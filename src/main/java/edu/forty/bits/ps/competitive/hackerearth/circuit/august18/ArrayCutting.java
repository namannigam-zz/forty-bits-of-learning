package org.practice.learning.competitive.hackerearth.circuit.august18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * This is an Approximate Problem
 *
 * You are given an array . Now you need to partition this array into  several sub arrays. Note that the partitions should be continuous i.e. if you arrange all the partitions one after another they should form the initial array completely.
 *
 * For example let the initial array  be  then example of few partitions are -
 *   - contains two partitions
 *   - contains three partitions
 *   - contains four partitions
 *
 * Now your goal is to partition the array  in such a way that if we sum the count of divisors of the each individual partition sum then it should be as minimum as possible. Since this is an approximate problem every partition that follows the continuous condition is valid , only the scores will be different. It is recommended to go through the scoring section and the output section carefully.
 *
 * Input
 * First line contains an integer  as input. Next line contains  space separated integers. Next line contains the value  denoting the count of cuts you need to make.
 *
 * Output
 * Your output should contain  distinct space separated integers (ascending order) that denotes the positions of your cuts. Note that each position should belong to the range  to  both included.
 * For example : Suppose that the array is  and you perform a partition  then it means that there are  cuts one before the index  and one before the last index  as the array is indexed from  to . So one of the valid outputs will be -
 * 2
 * 1 3
 *
 * Constraints
 *
 *
 * Scoring and Verdicts
 * If your output format does not matches the one described above then you may get a runtime error or a wrong answer. If the partition is correct then you will get AC with a certain score for which it may be possible to increase/decrease the score with certain optimizations.
 * Suppose that the sum of the count of divisors of each partition is  then your score is  and your goal is to minimize this score as much possible. Lesser the score more better is the solution.
 */
public class ArrayCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 1<=N<=10000
        int A[] = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray(); //1<=Ai<=1000
        int K = scanner.nextInt(); // 1<=K<=floor(N/2)
        /**
         if we sum the count of divisors of the each individual partition sum then it should be as minimum as possible.
         */
        int output[] = new int[K];
        int minimumSum = Integer.MAX_VALUE;
    }

    private int individualPartitionSum(int[] a) {
        return Arrays.stream(a).sum();
    }

    private static int countDivisorsOfIndividualPartitionSum(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    cnt++;
                } else {
                    cnt = cnt + 2;
                }
            }
        }
        return cnt;
    }

    private int sumOfCountOfDivisorsOfIndividualPartitionSum(int... a) {
        return Arrays.stream(a).sum();
    }
}