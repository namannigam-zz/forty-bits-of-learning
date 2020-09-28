package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnsafeElementInMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int min = Integer.MAX_VALUE;
            int max = 0;
            int[][] arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int val = scanner.nextInt();
                    arr[j][k] = val;
                    if (val > max) {
                        max = val;
                    }
                    if (val < min) {
                        min = val;
                    }
                }
            }

            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k] == max || arr[j][k] == min) {
                        rows.add(j);
                        cols.add(k);
                    }
                }
            }


            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!rows.contains(j) && !cols.contains(k)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}