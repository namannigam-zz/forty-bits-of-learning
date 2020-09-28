package edu.forty.bits.problemsolving.competitive.anzen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find the maximum from the length of subsets of an array with average less than K
 */
public class HighestAverageUsingPowerSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] set = java.util.stream.IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
        int Q = scanner.nextInt();

        for (int j = 0; j < Q; j++) {

            int K = scanner.nextInt();
            int maxLength = 0;
            int n = set.length;

            /*set_size of power set of a set with set_size n is (2**n -1)*/
            long pow_set_size = (long) Math.pow(2, n);

            /*Run from counter 000..0 to 111..1*/
            for (int counter = 0; counter < pow_set_size; counter++) {

                List<Integer> tempSet = new ArrayList<>();

                for (int k = 0; k < n; k++) {

                    /* Check if jth bit in the counter is set If set then pront jth element from set */
                    if ((counter & (1 << k)) > 0) {
                        tempSet.add(set[k]);
                    }
                }

                if (!tempSet.isEmpty() && averageOfSet(tempSet) < K) {
                    if (tempSet.size() > maxLength) {
                        maxLength = tempSet.size();
                    }
                }
            }

            System.out.println(maxLength);
        }
    }

    private static int averageOfSet(List<Integer> list) {
        int sum = list.stream().mapToInt(i -> i).sum();
        return sum / list.size();
    }
}
