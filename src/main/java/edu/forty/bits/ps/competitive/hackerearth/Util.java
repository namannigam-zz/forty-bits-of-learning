package org.practice.learning.competitive.hackerearth;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Util {

    private final Scanner scanner = new Scanner(System.in);

    static void solve() {

    }


    public static void main(String[] args) throws Exception {
        solve();
    }

    private boolean isSpaceChar(int c) {
        return Character.isSpaceChar((char) c);
    }

    private char[][] scanArrayOfStringvalues(int n) {
        return IntStream.range(0, n).mapToObj(i -> scanner.next().toCharArray()).toArray(char[][]::new);
    }

    private int[] scanArrayOfIntegerValues(int n) {
        return IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
    }

    private long[] scanArrayOfLongValues(int n) {
        return IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
    }

    private double[] scanArrayOfDoubleValues(int n) {
        return IntStream.range(0, n).mapToDouble(i -> scanner.nextDouble()).toArray();
    }


    public static long pow(long a, long n, long mod) {
        long ret = 1;
        int x = 63 - Long.numberOfLeadingZeros(n);
        for (; x >= 0; x--) {
            ret = ret * ret % mod;
            if (n << 63 - x < 0)
                ret = ret * a % mod;
        }
        return ret;
    }

    public static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }
}