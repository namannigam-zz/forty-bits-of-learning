package edu.forty.bits.ds.array;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The similarity of two documents  is defined to be the size of intersection divided by the size of the union.
 * For example if the documents consists of integers, the similarity of {1,3,5} and {1,7,2,3} would be 0.4.
 * We have a long list of documents  where the similarity s believed to be "sparse". That is two documents selected
 * are very likely to have similarity score as 0. Design an algorithm to list a pair of documents and associated
 * similarity, print only those with similarity greater than 0. Empty documents should not be printed at all.
 * Assume: For simplicity, all documents consists of distinct integers.
 */
public class SparseSimilarity {

    // a brute force approach could be to compare each documents with the remaining documents,
    // after finding the similarity score for each pair, list only those which are greater than 0
    // Note: This would be O(D^2) for D number of documents.
    List<SimilarPair> sparseSimilarity(Map<String, Set<Integer>> documents) {
        return new ArrayList<>();

    }

    // Sorting the documents would be O(L log(L)) to then search within

    // The union operation on the other hand is O(A+B) for adding all elements of both sets as seen
    // The intersection operation is O(A) for A as length of one of the documents with smaller size.
    // Both the above operation are possible to be combined in one, while iterating over
    double similarityScore(Set<Integer> one, Set<Integer> two) {
        Set<Integer> union = Stream.concat(one.stream(), two.stream()).collect(Collectors.toSet());
        Set<Integer> intersection = one.stream().filter(two::contains).collect(Collectors.toSet());

        Map<Boolean, Long> map = Stream.concat(one.stream(), two.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.partitioningBy(e -> e.getValue() > 1, Collectors.counting()));
        double similarityScore = (double) map.get(Boolean.TRUE) / (map.get(Boolean.TRUE) + map.get(Boolean.FALSE));

        return (double) intersection.size() / union.size();
    }


    // Since we are only interested in the similarity score greater than 0, we would need to exclude out
    // documents that are dissimilar.


    // Group documents by the values they include as a pre-compute can help and
    // then evaluate similarity score for each pair within these grouped list.
    // The problem further would be to avoid computing the score for a pair of documents already visited.

    // If you iterate through documents now, you need to find the list of documents(from values merged)
    // from the computed grouping which are similar to current document.

    // Can you compare the similarity directly from the pre-computed map?

    @Getter
    @AllArgsConstructor
    static class SimilarPair {
        String documentOne;
        String documentTwo;
        double similarityScore;
    }
}