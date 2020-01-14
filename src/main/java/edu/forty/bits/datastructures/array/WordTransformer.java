package edu.forty.bits.datastructures.array;

import edu.forty.bits.datastructures.annotations.Array;
import edu.forty.bits.datastructures.annotations.Graph;
import edu.forty.bits.datastructures.annotations.Tree;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two words of equal length that are in a dictionary, write a method to transform
 * one word into another word by changing only letter at a time.
 * The new word you get in each step must be in dictionary.
 */
@Array
@Tree
@Graph
public class WordTransformer {

    private static List<String> transform(Set<String> visited, String startWord, String stopWord, Set<String> dictionary) {
        if (startWord.equals(stopWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(startWord);
            return path;
        } else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
            return null;
        }

        visited.add(startWord);
        List<String> words = wordsOneAway(startWord);

        for (String word : words) {
            List<String> path = transform(visited, word, stopWord, dictionary);
            if (path != null) {
                path.add(startWord);
                return path;
            }
        }
        return null;
    }

    private static List<String> wordsOneAway(String word) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String w = word.substring(0, i) + c + word.substring(i + 1);
                words.add(w);
            }
        }
        return words;
    }

    /* find path to transform startWord into endWord. */
    public static List<String> transform(String start, String stop, String[] words) {
        Map<String, List<String>> wildcardToWordList = createWildcardToWordMap(words);
        Set<String> visited = new HashSet<>();
        return transform(visited, start, stop, wildcardToWordList);
    }

    // Using a Trie representation can help traverse to only those words present in the dictionary
    // Grouping words in dictionary, based on the prefix and suffix could provide all the valid one edit away words

    /* Do a depth-first search from start to stop, traveling through each word that is one edit away. */
    public static List<String> transform(Set<String> visited, String start, String stop, Map<String, List<String>> wildcardToWordList) {
        if (start.equals(stop)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(start);
            return path;
        } else if (visited.contains(start)) {
            return null;
        }

        visited.add(start);
        List<String> words = getValidLinkedWords(start, wildcardToWordList);

        for (String word : words) {
            List<String> path = transform(visited, word, stop, wildcardToWordList);
            if (path != null) {
                path.add(start);
                return path;
            }
        }

        return null;
    }

    /* Insert words in dictionary into mapping from wildcard form -> word. */
    private static Map<String, List<String>> createWildcardToWordMap(String[] words) {
        return Arrays.stream(words)
                .flatMap(w -> getWildcardRoots(w).stream())
                .collect(Collectors.groupingBy(Function.identity()));
    }

    /* Get list of wildcards associated with word. */
    private static List<String> getWildcardRoots(String w) {
        return IntStream.range(0, w.length())
                .mapToObj(i -> w.substring(0, i) + "_" + w.substring(i + 1))
                .collect(Collectors.toList());
    }

    /* Return words that are one edit away. */
    private static List<String> getValidLinkedWords(String word, Map<String, List<String>> wildcardToWords) {
        List<String> wildcards = getWildcardRoots(word);
        List<String> linkedWords = new ArrayList<>();
        for (String wildcard : wildcards) {
            List<String> words = wildcardToWords.get(wildcard);
            for (String linkedWord : words) {
                if (!linkedWord.equals(word)) {
                    linkedWords.add(linkedWord);
                }
            }
        }
        return linkedWords;
    }

    public static List<String> transformBidirectionally(String startWord, String stopWord, String[] words) {
        Map<String, List<String>> wildcardToWordList = createWildcardToWordMap(words);

        BFSData sourceData = new BFSData(startWord);
        BFSData destData = new BFSData(stopWord);

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source. */
            String collision = searchLevel(wildcardToWordList, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }

            /* Search out from destination. */
            collision = searchLevel(wildcardToWordList, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }
        }

        return null;
    }

    // Remember Bidirectional Search in Graphs? (optimised)
    // Traversing both the source and destination strings would reduce the runtime from O(k^d) to O(k^d/2)

    /* Search one level and return collision, if any. */
    private static String searchLevel(Map<String, List<String>> wildcardToWordList, BFSData primary, BFSData secondary) {
        /* We only want to search one level at a time. Count how many nodes are currently in the primary's
         * level and only do that many nodes. We'll continue to add nodes to the end. */
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /* Pull out first node. */
            PathNode pathNode = primary.toVisit.poll();
            String word = pathNode.getWord();

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(word)) {
                return pathNode.getWord();
            }

            /* Add friends to queue. */
            List<String> words = getValidLinkedWords(word, wildcardToWordList);
            for (String w : words) {
                if (!primary.visited.containsKey(w)) {
                    PathNode next = new PathNode(w, pathNode);
                    primary.visited.put(w, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }

    private static List<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
        PathNode end1 = bfs1.visited.get(connection); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
        LinkedList<String> pathOne = new LinkedList<>(end1.collapse(false)); // forward: source -> connection
        LinkedList<String> pathTwo = new LinkedList<>(end2.collapse(true)); // reverse: connection -> dest
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }

    public static void main(String[] args) {
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
        List<String> list = transformBidirectionally("tree", "flat", words);

        if (list == null) {
            System.out.println("No path.");
        } else {
            System.out.println(list.toString());
        }
    }

    // Brute force might be to get all the words that are one edit away and then selecting
    // each of them in present in the dictionary to call the method again recursively. Note: This would
    // involve marking the strings already seen as visited.
    // This approach resembles DFS, once can think of performing a BFS.
    List<String> transform(String source, String destination, Set<String> dictionary) {
        Set<String> visited = new HashSet<>();
        return transform(visited, source, destination, dictionary);
    }

    @Getter
    @AllArgsConstructor
    static class PathNode {
        private String word;
        private PathNode previousNode;

        /* Traverse path and return linked list of nodes. */
        List<String> collapse(boolean startsWithRoot) {
            LinkedList<String> path = new LinkedList<>();
            PathNode node = this;
            while (node != null) {
                if (startsWithRoot) {
                    path.addLast(node.word);
                } else {
                    path.addFirst(node.word);
                }
                node = node.previousNode;
            }
            return path;
        }
    }

    static class BFSData {
        Queue<PathNode> toVisit = new LinkedList<>();
        Map<String, PathNode> visited = new HashMap<>();

        BFSData(String root) {
            PathNode sourcePath = new PathNode(root, null);
            toVisit.add(sourcePath);
            visited.put(root, sourcePath);
        }

        boolean isFinished() {
            return toVisit.isEmpty();
        }
    }
}