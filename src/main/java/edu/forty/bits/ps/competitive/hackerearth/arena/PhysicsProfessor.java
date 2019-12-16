package edu.forty.bits.ps.competitive.hackerearth.arena;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PhysicsProfessor {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] knw = IntStream.range(0, N).map(j -> scanner.nextInt()).toArray();
            Arrays.sort(knw);
            int min = knw[(N / 2) - 1] + knw[N / 2];
            int max = knw[0] + knw[N - 1];
            System.out.println(max - min);
        }
    }
}
