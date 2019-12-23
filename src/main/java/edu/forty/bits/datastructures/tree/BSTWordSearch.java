package edu.forty.bits.datastructures.tree;

public class BSTWordSearch<E> {
    // root passed from method call for a node
    public boolean findWord(String word, String root) {
        return root.equals(word);
    }

    public boolean findPrefix(String prefix, String root) {
        return root.contains(prefix);
    }

    protected boolean contains(E item, BSTNode<E> tree) {
        String lookingFor = "searchTHISword";
        if (tree == null) return false;
        if (findWord(lookingFor, tree.getInfo())) {
            System.out.println("Found the entire word here.");
            return true;
        }
        if (findPrefix(lookingFor, tree.getInfo())) {
            System.out.println("Found the word as a prefix here.");
            return true;
        }
        //        if (item.compareTo(tree.getInfo()) < 0)
        //            return contains(item, tree.getLeft());
        //        else
        //            return contains(item, tree.getRight());
        return true;
    }
    // Would return false, it what you are looking for is nowhere in the BST
}
