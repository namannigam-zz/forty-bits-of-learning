package edu.forty.bits.datastructures.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a string B and an array of smaller strings T, design a method to search B for each small string in T.
 */
public class MultiSearch {

    // Its important to start off with an example that can help you build the problem
    // e.g. T = {"is","ppi","hi","sis","i","ssipi"} and B = "mississippi"

    // Brute force solution iterates over each strings each character with a time complexity of O(K*B*T)
    public static boolean isSubstringAtLocation(String big, String small, int offset) {
        return IntStream.range(0, small.length())
                .allMatch(i -> big.charAt(offset + i) == small.charAt(i));
    }

    public static List<Integer> search(String big, String small) {
        return IntStream.range(0, big.length() - small.length() + 1)
                .filter(i -> isSubstringAtLocation(big, small, i))
                .boxed()
                .collect(Collectors.toList());
    }


    public static Map<String, List<Integer>> searchAll(String big, String[] smalls) {
        return Arrays.stream(smalls)
                .collect(Collectors.toMap(small -> small,
                        small -> search(big, small), (a, b) -> b));
    }


    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        Map<String, List<Integer>> locations = searchAll(big, smalls);
        System.out.println(locations.toString());
    }

    // another solution could be to make use of a trie by creating trie-like data structure for each substring of B
    // this takes O(B^2) time to create the trie from B and O(K*T) time for searching locations
    // Total complexity of O(B^2 + KT) cannot be compared to O(KBT) directly, they have trade-offs
    // depending on the size of B.
    public static void subtractValue(List<Integer> locations, int delta) {
        if (locations == null) return;
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }
    }

    public static Trie createTrieFromString(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            trie.insertString(suffix, i);
        }
        return trie;
    }

    public static Map<String, List<Integer>> searchAllWithTrie(String big, String[] smalls) {
        Map<String, List<Integer>> lookup = new HashMap<>();
        Trie tree = createTrieFromString(big);
        for (String s : smalls) {
            /* Get terminating location of each occurrence.*/
            List<Integer> locations = tree.search(s);

            /* Adjust to starting location. */
            subtractValue(locations, s.length());

            /* Insert. */
            lookup.put(s, locations);
        }

        return lookup;
    }

    // another way is to create the trie would be using the smaller arrays which means a
    // time complexity of O(K*T) time to create trie.
    // searching for words in trie while traversing each character in the bigger string and storing their indexes
    // while found in the trie would take complexity of O(B*K) time
    public static Trie createTreeFromStrings(String[] smalls, int maxSize) {
        Trie tree = new Trie();
        for (String s : smalls) {
            if (s.length() <= maxSize) {
                tree.insertString(s, 0);
            }
        }
        return tree;
    }

    public static List<String> findStringsAtLoc(Trie.TrieNode root, String big, int start) {
        List<String> strings = new ArrayList<>();
        int index = start;
        while (index < big.length()) {
            root = root.getChild(big.charAt(index));
            if (root == null) break;
            if (root.terminates()) {
                strings.add(big.substring(start, index + 1));
            }
            index++;

        }
        return strings;
    }

    public static void insertIntoHashMap(List<String> strings, Map<String, List<Integer>> map, int index) {
        for (String s : strings) {
            map.merge(s, Arrays.asList(index), (integers, integers2) -> {
                integers.addAll(integers2);
                return integers;
            });
        }
    }

    public static Map<String, List<Integer>> searchAllWithTrieOfT(String big, String[] smalls) {
        Map<String, List<Integer>> lookup = new HashMap<>();
        Trie.TrieNode root = createTreeFromStrings(smalls, big.length()).getRoot();
        for (int i = 0; i < big.length(); i++) {
            List<String> strings = findStringsAtLoc(root, big, i);
            insertIntoHashMap(strings, lookup, i);
        }
        return lookup;
    }

    // The last solution stands better than both the previous solutions considering trade-offs as well.
}