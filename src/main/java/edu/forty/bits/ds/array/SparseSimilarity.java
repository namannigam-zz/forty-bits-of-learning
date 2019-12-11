package edu.forty.bits.ds.array;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SparseSimilarity {

    List<SimilarPair> sparseSimilarity(Map<String, Set<Integer>> documents) {
        return new ArrayList<>();
    }

    double similarityScore(Set<Integer> one, Set<Integer> two) {
        Set<Integer> union = Stream.concat(one.stream(), two.stream()).collect(Collectors.toSet());
        Set<Integer> intersection = one.stream().filter(two::contains).collect(Collectors.toSet());
        return (double) intersection.size() / union.size();
    }

    @Getter
    @AllArgsConstructor
    static class SimilarPair {
        String documentOne;
        String documentTwo;
        double similarityScore;
    }
}