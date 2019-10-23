package org.practice.learning.competitive.hackerearth.circuit.august18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Noor is going fish farming. There are N types of fish. Each type of fish has size(S) and eating factor(E).
 * A fish with eating factor of E, will eat all the fish of size <= E.
 *
 * Help Noor to select a set of fish such that the size of the set is maximized as well as they do not eat each other.
 */
public class NoorsPond {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            List<Fish> fishes = IntStream.range(0, N)
                    .mapToObj(j -> new Fish(scanner.nextLong(), scanner.nextLong()))
                    .collect(Collectors.toCollection(() -> new ArrayList<>(N)));
            System.out.println(fishes.size());
        }
    }


    private static class Fish {
        long eatingFactor;
        long size;

        Fish(long eatingFactor, long size) {
            this.eatingFactor = eatingFactor;
            this.size = size;
        }
    }
}