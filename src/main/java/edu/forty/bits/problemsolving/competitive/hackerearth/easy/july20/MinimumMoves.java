package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;

import java.util.Scanner;

public class MinimumMoves {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long minSteps;
            if (y > x || x < 0 || y < 0) {
                minSteps = -1;
            } else if (y == x) {
                minSteps = x;
            } else {
                minSteps = x;
            }
            System.out.println(minSteps);
        }
    }
}