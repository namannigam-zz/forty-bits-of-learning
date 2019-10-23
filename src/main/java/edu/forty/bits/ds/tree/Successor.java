package org.practice.learning.tree;

// next element is supposedly the in-order successor of an element
// given the parent is provided for each node
public class Successor {

    TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            return leftMostChild(node.right);
        } else {
            TreeNode q = node;
            TreeNode x = q.parent;
            // check if the current node is not the left node of the parent, go up in the hierarchy referentially
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private TreeNode leftMostChild(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}