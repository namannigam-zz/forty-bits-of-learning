package edu.forty.bits.datastructures.tree;
/**
 * Implement a function to check if a binary tree is balanced. For the purpose of the question, a balanced tree
 * is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced {

    // definition of a balanced tree is must to clarify in such questions,
    // here it is true if any sub tree is of no more height than its sibling by a difference of 1.
    // get the height of the tree and compute the total number of nodes
    private int getHeight(TreeNode root) {
        if (root.isLeaf()) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Using a brute force approach, this runs in O(N logN) since it touches every node once per node above it
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        return heightDiff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // a better way to do that is while evaluating the height also check for the condition itself
    private int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // escalating the error case

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // escalating the error case

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDiff > 1) {
            return Integer.MIN_VALUE; // return a failure here
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // then consume it as, this reduces the runtime to O(N), given that the extra space occupied is
    // O(H),
    // where H is the height of the tree
    boolean isBalancedJustWithHeight(TreeNode treeNode) {
        return checkHeight(treeNode) != Integer.MIN_VALUE;
    }
}