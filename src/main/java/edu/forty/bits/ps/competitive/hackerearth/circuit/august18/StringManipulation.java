package edu.forty.bits.ps.competitive.hackerearth.circuit.august18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        int count[] = new int[26];
        // Initialize count array index
        IntStream.range(0, N).forEach(i -> count[str.charAt(i) - 'a']++);
        Arrays.sort(count);
        System.out.println(N - count[25]);
    }
}