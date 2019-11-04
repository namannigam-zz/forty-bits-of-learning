package edu.forty.bits.ds.tree;

/**
 * Created by naman.nigam on 08/02/16.
 */

public class TreeNode {
    int data;
    public TreeNode left, right;
    public TreeNode parent;

    public TreeNode(int x) {
        data = x;
        left = right = null;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }
}
