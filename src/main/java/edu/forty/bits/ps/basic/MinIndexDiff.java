package org.practice.learning.basic;

import java.util.*;

public class MinIndexDiff {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SavingUniverse. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int diff = n;
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int j = 0;
             j < n;
             j++) {
            A.add(j, scan.nextInt());
        }
        for (int k = 0;
             k < n;
             k++) {
            B.add(k, scan.nextInt());
        }
        int result = B.get(0);
        for (int i = 0;
             i < n;
             i++) {
            int indexDiff = Math.abs(i - (A.indexOf(B.get(i))));
            if (diff > indexDiff) {
                diff = indexDiff;
                result = B.get(i);
            }
            if (diff == indexDiff) {
                if (result > B.get(i)) {
                    result = B.get(i);
                }
            }
        }
        System.out.print(result);
    }
}