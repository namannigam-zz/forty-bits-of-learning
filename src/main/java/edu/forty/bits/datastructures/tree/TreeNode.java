package edu.forty.bits.datastructures.tree;

/**
 * Created by naman.nigam on 08/02/16.
 */
public class TreeNode {
    public TreeNode left, right;
    public TreeNode parent;
    int data;

    public TreeNode(int x) {
        data = x;
        left = right = null;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }
}
