package edu.forty.bits.ds.tree;

import java.util.Stack;

/** Created by naman.nigam on 08/02/16. */
public class LeafOrderTraversal {
  // Returns true of leaf traversal of two trees is
  // same, else false
  public static boolean isSame(TreeNode root1, TreeNode root2) {
    // Create empty stacks.  These stacks are going
    // to be used for iterative traversals.
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    s1.push(root1);
    s2.push(root2);

    // Loop until either of two stacks is not empty
    while (!s1.empty() || !s2.empty()) {
      // If one of the stacks is empty means other
      // stack has extra leaves so return false
      if (s1.empty() || s2.empty()) return false;

      TreeNode temp1 = s1.pop();
      while (temp1 != null && !temp1.isLeaf()) {
        // Push right and left children of temp1.
        // Note that right child is inserted
        // before left
        if (temp1.right != null) s1.push(temp1.right);
        if (temp1.left != null) s1.push(temp1.left);
        temp1 = s1.pop();
      }

      // same for tree2
      TreeNode temp2 = s2.pop();
      while (temp2 != null && !temp2.isLeaf()) {
        if (temp2.right != null) s2.push(temp2.right);
        if (temp2.left != null) s2.push(temp2.left);
        temp2 = s2.pop();
      }

      // If one is null and other is not, then
      // return false
      if (temp1 == null && temp2 != null) return false;
      if (temp1 != null && temp2 == null) return false;

      // If both are not null and data is not
      // same return false
      if (temp1 != null && temp2 != null) {
        if (temp1.data != temp2.data) return false;
      }
    }

    // If control reaches this point, all leaves
    // are matched
    return true;
  }
}
