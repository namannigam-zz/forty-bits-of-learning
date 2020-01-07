package edu.forty.bits.datastructures.graph;

import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Each year, the govt. releases a list of the 10000 most common baby names and their frequencies.
 * The only problem with this is that some names have multiple spellings. For example "John" and "Jon"
 * which are essentially the same name but are listed separately. Given two lists, once of the names
 * and frequency and the other of the pairs of equivalent names, write an algorithm to print a new list
 * of the true frequency of each name. Note that, the pairs are both transitive and symmetric. In the final
 * list, any name can be used as a real name.
 */
public class BabyNames {

    // todo: time-complexity?
    private Map<String, Integer> mergeFrequencies(Map<String, Integer> nameFrequencies, List<Pair> pairs) {
        Map<Pair, Set<String>> collectivePairs = pairs.stream()
                .collect(Collectors.toMap(Function.identity(),
                        pair -> new HashSet<>(Arrays.asList(pair.getSource(), pair.getDestination())),
                        (pair1, pair2) -> {
                            pair1.addAll(pair2);
                            return pair1;
                        }));
        return collectivePairs.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getSource(),
                        e -> e.getValue().stream()
                                .mapToInt(nameFrequencies::get).sum()));
        // the above implementation missed the names, that are a part of the frequency map
        // but do not have any synonym
    }

    @Getter
    static class Pair {
        String source;
        String destination;

        // implement equals in such a way that even if any of source or destination matches,
        // one finds the pairs as equal
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(source, pair.source) || Objects.equals(source, pair.destination) ||
                    Objects.equals(destination, pair.destination) || Objects.equals(destination, pair.source);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }
    }


    // Another approach would be creating a graph while iterating the synonym pairs
    // and traversing each of its node performing a DFS/BFS to get the values from frequency table
}