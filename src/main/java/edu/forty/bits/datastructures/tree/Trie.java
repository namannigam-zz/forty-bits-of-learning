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

    /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
    public Trie(List<String> list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }


    /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
    public Trie(String[] list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    /* Checks whether this trie contains a string with the prefix passed
     * in as argument.
     */
    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        int i = 0;
        for (i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }


    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean terminates = false;

        // The character stored in this node as data.
        private char character;
        private List<Integer> indexes;

        public TrieNode() {
            children = new HashMap<>();
            indexes = new ArrayList<>();
        }

        /* Constructs a trie node and stores in the node the char passed in
         * as the argument. Initializes the list of child nodes of this
         * node to an empty hash map.
         */
        public TrieNode(char character) {
            this();
            this.character = character;
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

        /* Add this word to the trie, and recursively create the child
         * nodes. */
        public void addWord(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            char firstChar = word.charAt(0);

            TrieNode child = getChild(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            if (word.length() > 1) {
                child.addWord(word.substring(1));
            } else {
                child.setTerminates(true);
            }
        }

        /* Find a child node of this node that has the char argument as its
         * data. Return null if no such child node is present in the trie.
         */
        public TrieNode getChild(char c) {
            return children.get(c);
        }

        /* Returns whether this node represents the end of a complete word. */
        public boolean terminates() {
            return terminates;
        }

        /* Set whether this node is the end of a complete word.*/
        public void setTerminates(boolean t) {
            terminates = t;
        }
    }
}