package org.practice.learning.competitive.hackerearth.circuit.july18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In this problem, we define "set" is a collection of distinct numbers. For two sets  and , we define their sum set is a set . In other word,  set  contains all elements which can be represented as sum of an element in  and an element in . Given two sets , your task is to find set  of positive integers less than or equals  with maximum size such that . It is guaranteed that there is unique such set.
 *
 * Input Format
 *
 * The first line contains  denoting the number of elements in set , the following line contains  space-separated integers  denoting the elements of set .
 *
 * The third line contains  denoting the number of elements in set , the following line contains  space-separated integers  denoting the elements of set .
 *
 * Output Format
 *
 * Print all elements of  in increasing order in a single line, separated by space.
 */
public class EasySumSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> A = IntStream.range(0, N).mapToObj(i -> scanner.nextInt()).sorted()
                .collect(Collectors.toCollection(() -> new ArrayList<>(N)));
        int M = scanner.nextInt();
        List<Integer> C = IntStream.range(0, M).mapToObj(i -> scanner.nextInt()).sorted()
                .collect(Collectors.toCollection(() -> new ArrayList<>(M)));

        int min = C.get(0) - A.get(0);
        int max = C.get(C.size() - 1) - A.get(A.size() - 1);
        List<Integer> B = new ArrayList<>();
        IntStream.rangeClosed(min, max)
                .forEach(i -> A.stream().filter(a -> C.contains(i + a) && !B.contains(i)).forEach(a -> B.add(i)));
        B.stream().map(b -> b + " ").forEach(System.out::print);
    }
}