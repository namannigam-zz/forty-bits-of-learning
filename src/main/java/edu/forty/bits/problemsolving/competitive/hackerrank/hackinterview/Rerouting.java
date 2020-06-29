package edu.forty.bits.problemsolving.competitive.hackerrank.hackinterview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rerouting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> connection = IntStream.range(0, n)
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toList());

        int result = getMinConnectionChange(connection);

        System.out.println(result);
    }

    public static int getMinConnectionChange(List<Integer> connection) {
        Map<Integer, Integer> sourceToNode = IntStream.range(0, connection.size())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, connection.get(i)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Integer, Set<Integer>> nodeToSources = sourceToNode.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));

        return connection.size();

    }

    // You are tasked with making minimum number of changes to "connection" array values so that
    // the information from all servers can reach at exactly one server in the whole network,
    // where it terminates.
    class Node {
        int source;
        int destination;
    }
}