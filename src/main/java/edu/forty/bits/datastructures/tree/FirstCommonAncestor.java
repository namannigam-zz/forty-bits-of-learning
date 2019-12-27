package edu.forty.bits.datastructures.tree;

import lombok.AllArgsConstructor;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. Note: This is not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    // validate - does the node have link to their parents?

    // with the links to the parents once can traverse back and find the common ancestor node
    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        if (p == q) return p;

        TreeNode ancestor = p;
        while (ancestor != null) {
            if (isOnPath(ancestor, q)) {
                return ancestor;
            }
            ancestor = ancestor.parent;
        }
        return null;
    }

    public static boolean isOnPath(TreeNode ancestor, TreeNode node) {
        while (node != ancestor && node != null) {
            node = node.parent;
        }
        return node == ancestor;
    }

    static final int TWO_NODES_FOUND = 2;
    static final int ONE_NODE_FOUND = 1;
    static final int NO_NODES_FOUND = 0;

    // Checks how many 'special' nodes are located under this root
    public static int covers(TreeNode root, TreeNode p, TreeNode q) {
        int ret = NO_NODES_FOUND;
        if (root == null) return ret;
        if (root == p || root == q) ret += 1;
        ret += covers(root.left, p, q);
        if (ret == TWO_NODES_FOUND) // Found p and q
            return ret;
        return ret + covers(root.right, p, q);
    }

    // this algorithm generally takes O(T) time for T being the length of first ancestor or  in the worst case
    // O(N) time for traversing all N nodes of the tree
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q == p && (root.left == q || root.right == q)) return root;
        int nodesFromLeft = covers(root.left, p, q); // Check left side
        if (nodesFromLeft == TWO_NODES_FOUND) {
            if (root.left == p || root.left == q) return root.left;
            else return commonAncestor(root.left, p, q);
        } else if (nodesFromLeft == ONE_NODE_FOUND) {
            if (root == p) return p;
            else if (root == q) return q;
        }

        int nodesFromRight = covers(root.right, p, q); // Check right side
        if (nodesFromRight == TWO_NODES_FOUND) {
            if (root.right == p || root.right == q) return root.right;
            else return commonAncestor(root.right, p, q);
        } else if (nodesFromRight == ONE_NODE_FOUND) {
            if (root == p) return p;
            else if (root == q) return q;
        }
        if (nodesFromLeft == ONE_NODE_FOUND &&
                nodesFromRight == ONE_NODE_FOUND) return root;
        else return null;
    }

    // without the links to the parents
    // one way is to figure out whether the given nodes are both on different side of a node(this would be the
    // ancestor node) in such a case

    @AllArgsConstructor
    public static class Result {
        private TreeNode node;
        private boolean isAncestor;
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            /* If we�re currently at p or q, and we also found one of those
             * nodes in a subtree, then this is truly an ancestor and the
             * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestorOptimised(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }
}