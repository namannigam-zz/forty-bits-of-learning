package edu.forty.bits.ds.array;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
    List<DocPair> sparseSimilarity(Map<String, Set<Integer>> documents) {
        return new ArrayList<>();

    }

    // Sorting the documents would be O(L log(L)) to then search within

    // The union operation on the other hand is O(A+B) for adding all elements of both sets as seen
    // The intersection operation is O(A) for A as length of one of the documents with smaller size.
    // Both the above operation are possible to be combined in one, while iterating over
    static double similarityScore(Set<Integer> one, Set<Integer> two) {
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
    static class DocPair {
        int documentOne;
        int documentTwo;
    }

    @Getter
    @AllArgsConstructor
    static class Document {
        private Set<Integer> words;
        private int docId;

        public int size() {
            return words == null ? 0 : words.size();
        }
    }

    public static Map<DocPair, Double> computeSimilarities(List<Document> documents) {
        Map<DocPair, Double> similarities = new HashMap<>();
        for (int i = 0; i < documents.size(); i++) {
            for (int j = i + 1; j < documents.size(); j++) {
                Document doc1 = documents.get(i);
                Document doc2 = documents.get(j);
                double sim = similarityScore(doc1.getWords(), doc2.getWords());
                if (sim > 0) {
                    DocPair pair = new DocPair(doc1.getDocId(), doc2.getDocId());
                    similarities.put(pair, sim);
                }
            }
        }
        return similarities;
    }

    public static List<Integer> removeDupes(int[] array) {
        return Arrays.stream(array).boxed().distinct().collect(Collectors.toList());
    }


    public static Map<DocPair, Double> computeSimilarities(Map<Integer, Document> documents) {
        Map<Integer, Set<Integer>> wordToDocs = groupWords(documents);
        Map<DocPair, Double> similarities = computeIntersections(wordToDocs);
        adjustToSimilarities(documents, similarities);
        return similarities;
    }

    /* Create hash table from each word to where it appears. */
    public static Map<Integer, Set<Integer>> groupWords(Map<Integer, Document> documents) {
        return documents.values().stream()
                .flatMap(d -> d.getWords().stream().map(w -> new AbstractMap.SimpleEntry<>(w, d.getDocId())))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.mapping(
                        Map.Entry::getValue, Collectors.toSet())));
    }

    /* Compute intersections of documents. Iterate through each list of
     * documents and then each pair within that list, incrementing the
     * intersection of each page. */
    public static Map<DocPair, Double> computeIntersections(Map<Integer, Set<Integer>> wordToDocs) {
        Map<DocPair, Double> similarities = new HashMap<>();
        Set<Integer> words = wordToDocs.keySet();
        for (int word : words) {
            List<Integer> docs = wordToDocs.get(word).stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < docs.size(); i++) {
                for (int j = i + 1; j < docs.size(); j++) {
                    increment(similarities, docs.get(i), docs.get(j));
                }
            }
        }

        return similarities;
    }

    /* Increment the intersection size of each document pair. */
    public static void increment(Map<DocPair, Double> similarities, int doc1, int doc2) {
        DocPair pair = new DocPair(doc1, doc2);
        similarities.put(pair, !similarities.containsKey(pair) ? 1.0 : similarities.get(pair) + 1);
    }

    /* Adjust the intersection value to become the similarity. */
    public static void adjustToSimilarities(Map<Integer, Document> documents, Map<DocPair, Double> similarities) {
        for (Map.Entry<DocPair, Double> entry : similarities.entrySet()) {
            DocPair pair = entry.getKey();
            Double intersection = entry.getValue();
            Document doc1 = documents.get(pair.getDocumentOne());
            Document doc2 = documents.get(pair.getDocumentTwo());
            double union = (double) doc1.size() + doc2.size() - intersection;
            entry.setValue(intersection / union);
        }
    }


    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Element implements Comparable<Element> {
        int word;
        int document;

        public int compareTo(Element e) {
            return word == e.word ? Integer.compare(document, e.document) : Integer.compare(word, e.word);
        }
    }

    /* Throw all words into one list, sorting by the word then the document. */
    public static List<Element> sortWords(Map<Integer, Document> docs) {
        return docs.values().stream()
                .flatMap(d -> d.getWords().stream().map(w -> new AbstractMap.SimpleEntry<>(d, w)))
                .map(e -> new Element(e.getValue(), e.getKey().getDocId()))
                .sorted()
                .collect(Collectors.toList());
    }

    /* Adjust the intersection value to become the similarity. */
    public static Map<DocPair, Double> computeIntersections(List<Element> elements) {
        Map<DocPair, Double> similarities = new HashMap<>();

        for (int i = 0; i < elements.size(); i++) {
            Element left = elements.get(i);
            for (int j = i + 1; j < elements.size(); j++) {
                Element right = elements.get(j);
                if (left.word != right.word) {
                    break;
                }
                increment(similarities, left.document, right.document);
            }
        }

        return similarities;
    }
}