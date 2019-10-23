package org.practice.learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

    // looks like a level traversal, but it could be solved using a pre-order (NLR) traversal easily
    // the traversal would basically take O(N) runtime since visiting all the nodes
    // though there would be log(N) recursive calls here to fill in the stack,
    // but then since the data to be returned is O(N), hence the log(N) is stunted
    private void createLevelLinkedList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // level not contained in list yet
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);

        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }


    // another way to achieve the same is using the BFS on the tree
    private List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() != 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}