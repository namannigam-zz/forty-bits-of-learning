package edu.forty.bits.problemsolving.competitive.hackerearth.easy.may20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistinctWithoutCubeProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> sequence = new ArrayList<>();
        for (int a = 0; a < N; a++) {
            Integer nextInt = scanner.nextInt();
            sequence.add(nextInt);
        }

        int count = 0;
        int prod = 1;
        for (int i = 0; i < N; i++) {
            int temp = prod * sequence.get(i);
            if (!isCube(temp)) {
                count++;
                prod = temp;
            }
        }
        System.out.println(count);
    }

    static boolean isCube(long input) {
        if (input == 1) return false;
        double cubeRoot = Math.pow(input, 1.0 / 3.0);
        return Math.round(cubeRoot) == cubeRoot;
    }
}