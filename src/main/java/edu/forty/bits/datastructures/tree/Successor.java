package edu.forty.bits.datastructures.tree;

/**
 * Write an algorithm to find the "next" node (in-order successor) of a given node in a binary
 * search tree. You may assume that each node has a link to its parent.
 */
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