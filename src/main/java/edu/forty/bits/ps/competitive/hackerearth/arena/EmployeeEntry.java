package edu.forty.bits.ps.competitive.hackerearth.arena;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeEntry {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            char[][] employeeNames = new char[N][K];

            for(int j = 0; j < N; j++) {
                char[] name = scanner.next().toCharArray();
                employeeNames[j] = name;
            }

            StringBuilder finalString = new StringBuilder();
            for(int j = 0; j < K; j++) {
                char[] characters = new char[N];
                for(int l = 0; l < N; l++) {
                    characters[l] = employeeNames[l][j];
                }
                Arrays.sort(characters);
                finalString.append(characters[(K/2)]);
            }
            System.out.println(finalString);
        }
    }
}