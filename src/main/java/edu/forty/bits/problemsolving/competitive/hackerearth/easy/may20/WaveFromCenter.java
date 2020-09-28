package edu.forty.bits.problemsolving.competitive.hackerearth.easy.may20;

import java.util.Scanner;

public class WaveFromCenter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int ci = scanner.nextInt();
        int cj = scanner.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(Math.max(Math.abs(i - ci), Math.abs(j - cj)));
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
