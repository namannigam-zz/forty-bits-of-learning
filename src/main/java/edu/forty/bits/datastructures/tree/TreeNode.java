package edu.forty.bits.datastructures.tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int data;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }
}