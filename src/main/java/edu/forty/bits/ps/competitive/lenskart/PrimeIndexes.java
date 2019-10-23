package org.practice.learning.competitive.lenskart;

import java.util.*;

/**
 * Created by naman.nigam on 08/10/16.
 */
public class PrimeIndexes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> primeIndexMap = new HashMap<>();
        for (int j = 0; j < N; j++) {
            int o = scanner.nextInt();
            if (isPrime(o)) {
                output.add(o);
            } else output.add(-1);
        }
        output.forEach(System.out::println);
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}