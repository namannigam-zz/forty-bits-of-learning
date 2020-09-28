package edu.forty.bits.datastructures.tree;

import lombok.Getter;

public class TreePrefix {

    private boolean recContainsPrefix(String prefixKey, BSTNode<String> tree) {
        // base case
        if (tree == null) return false;

        // test if each node starts with the prefix.
        if (tree.getInfo().startsWith(prefixKey)) {
            return true;
        }
        // recursive case.
        else if (prefixKey.compareTo(tree.getInfo()) < 0)
            return recContainsPrefix(prefixKey, tree.getLeft());
            // recursive case.
        else if (prefixKey.compareTo(tree.getInfo()) > 0)
            return recContainsPrefix(prefixKey, tree.getRight());
        else {
            return true;
        }
    }

    @Getter
    public class BSTNode<E> {
        private String info;
        private BSTNode<E> left;
        private BSTNode<E> right;
    }
}