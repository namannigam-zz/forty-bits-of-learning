package edu.forty.bits.datastructures.tree;

import java.util.*;

public class Trie {
    private TrieNode root = new TrieNode();

    public List<Integer> search(String s) {
        return root.search(s);
    }

    public void insertString(String str, int location) {
        root.insertString(str, location);
    }

    public TrieNode getRoot() {
        return root;
    }


    class TrieNode {
        private Map<Character, TrieNode> children;
        private List<Integer> indexes;

        public TrieNode() {
            children = new HashMap<>();
            indexes = new ArrayList<>();
        }


        public void insertString(String s, int index) {
            if (s == null) return;
            indexes.add(index);
            if (s.length() > 0) {
                char value = s.charAt(0);
                TrieNode child = null;
                if (children.containsKey(value)) {
                    child = children.get(value);
                } else {
                    child = new TrieNode();
                    children.put(value, child);
                }
                String remainder = s.substring(1);
                child.insertString(remainder, index + 1);
            } else {
                children.put('\0', null);
            }
        }

        public List<Integer> search(String s) {
            if (s == null || s.length() == 0) {
                return indexes;
            } else {
                char first = s.charAt(0);
                if (children.containsKey(first)) {
                    String remainder = s.substring(1);
                    return children.get(first).search(remainder);
                }
            }
            return Collections.emptyList();
        }

        public boolean terminates() {
            return children.containsKey('\0');
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }
    }
}