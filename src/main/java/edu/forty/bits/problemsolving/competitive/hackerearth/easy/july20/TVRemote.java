package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;

import java.util.Scanner;

public class TVRemote {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            System.out.println(ways(0, n));
        }
    }

    static long ways(int pos, long steps) {
        if (steps == 0) return 0;
        if (steps == 1) return 1;
        return ways(pos, steps - 1) +
                ways(pos - 1, steps - 1) +
                ways(pos + 1, steps - 1);
    }
}