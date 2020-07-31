package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProfitByCars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Long> prices = IntStream.range(0, n)
                    .mapToObj(a -> scanner.nextLong())
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(prices.stream().mapToLong(it -> it).sum());
        }
    }
}