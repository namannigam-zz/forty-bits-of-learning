package edu.forty.bits.datastructures.tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int data;
    private int size = 0;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }
}