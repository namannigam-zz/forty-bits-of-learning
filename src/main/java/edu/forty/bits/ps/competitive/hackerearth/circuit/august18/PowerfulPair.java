package edu.forty.bits.ps.competitive.hackerearth.circuit.august18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Let’s define a term “Powerful Pair” as pair of two integer numbers, say A and B such that bitwise xor of these integers ( say, A xor B ) is a power of 2.
 *
 * You are given a tree rooted at vertex 1 and total N vertices where each node contains a value in it. You have to answer Q queries. In each query, you will be given two vertices U and V, your task is to count the number of pairs of vertices (X, Y) (not necessarily distinct) such that X belongs to the subtree rooted at U and Y belongs to the subtree rooted at V and values in these vertices form a Power Pair.
 *
 * Input:
 *
 * Input starts with an integer N (1<=N<=100000), denoting the total number of nodes in tree. Next line contain N space separated integers denoting the values in node starting from 1 to N, which is nonnegative integer having value at most 100000. Next N-1 line contain two space separated integers, denoting an edge in tree. Next line will contain a single integer Q (1<=Q<=100000), denoting total number of quires. Following Q lines will contain two integers U and V separated by space between them.
 *
 * Output:
 *
 * For each query, output an integer denoting total number of ways of forming powerful pairing in between the values of subtrees given in each query.
 */
public class PowerfulPair {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = IntStream.range(0, N)
                .mapToObj(j -> scanner.nextInt())
                .collect(Collectors.toCollection(() -> new ArrayList<>(N)));
        Map<Integer, Integer> sourceToDestination = IntStream.range(0, N - 1).boxed()
                .collect(Collectors.toMap(i -> scanner.nextInt(),
                        i -> scanner.nextInt(), (a, b) -> b,
                        () -> new HashMap<>(N - 1)));

        int Q = scanner.nextInt();
        Map<Integer, Integer> sourceToDestinationQuery = IntStream.range(0, Q).boxed()
                .collect(Collectors.toMap(i -> scanner.nextInt(),
                        i -> scanner.nextInt(), (a, b) -> b,
                        () -> new HashMap<>(Q)));
    }


    private static boolean isPowerPair(int A, int B) {
        return countSetBits(A ^ B) == 1;
    }

    // recursive function to count set bits
    private static int countSetBits(int n) {
        if (n == 0) { // base case
            return 0;
        } else { // if last bit set add 1 else add 0
            return (n & 1) + countSetBits(n >> 1);
        }
    }
}