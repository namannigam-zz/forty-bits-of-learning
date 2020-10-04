package edu.forty.bits.problemsolving.competitive.equalsexperts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IncreasingSubsequencesEnergy {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        List<Integer> input = new ArrayList<>();
        java.util.stream.IntStream.range(0, N).forEach(i -> input.add(s.nextInt()));
        Collections.sort(input);
        if (K > N) {
            System.out.println("-1");
        } else {
            // sum of difference of consecutive numbers in the subsequence
            // states that b-a + c-b which would be c-a eventually
            // hence the difference between the smallest and largest should always be the max
            System.out.println(input.get(input.size() - 1) - input.get(0));
        }
    }
}
