package edu.forty.bits.problemsolving.competitive.hackerearth.circuit.july18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given a string S and N strings T1,T2,...TN. A
 * string is considered good iff we can reorder its characters such
 * that it becomes some string . You are asked to count the number of
 * ways to partition into several good substrings. As the answer can be very large, we are only
 * interested in modulo .
 *
 * <p>Input Format
 *
 * <p>The first line contains a string and an integer .
 *
 * <p>The next lines, each line contains a string .
 *
 * <p>All characters in strings are lowercase English letters.
 *
 * <p>Output Format
 *
 * <p>Output the answer in a single line
 */
public class PartitionString {

    public static void main(String[] args) {
        long M = 1000000007;
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int N = scanner.nextInt();
        List<String> tStrings =
                IntStream.range(0, N).mapToObj(i -> scanner.next()).collect(Collectors.toList());
        List<List<String>> partitions = partitions(S).collect(Collectors.toList());
        long count = Math.floorMod(partitions.stream().filter(tStrings::removeAll).count(), M);
        System.out.println(count);
    }

    private static Stream<List<String>> partitions(String text) {
        if (text.isEmpty()) {
            return Stream.of(new ArrayList<>());
        } else {
            return IntStream.rangeClosed(1, text.length())
                    .boxed()
                    .flatMap(i -> partitions(text.substring(i)).peek(p -> p.add(0, text.substring(0, i))));
        }
    }
}
