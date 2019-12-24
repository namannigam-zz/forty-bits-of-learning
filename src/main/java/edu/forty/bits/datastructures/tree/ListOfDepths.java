package edu.forty.bits.datastructures.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, design an algorithm which creates a linked list for all nodes at each depth
 * e.g. if you have a tree with depth D, you'll have D linked lists
 */
public class ListOfDepths {

    // looks like a level traversal, but it could be solved using a pre-order (NLR) traversal easily
    // the traversal would basically take O(N) runtime since visiting all the nodes
    // though there would be log(N) recursive calls here to fill in the stack,
    // but then since the data to be returned is O(N), hence the log(N) is stunted
    public static void createLevelLinkedList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<>();
            /* Levels are always traversed in order. So, if this is the first time we've visited level i,
             * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void printResult(List<LinkedList<TreeNode>> result) {
        for (int depth = 0; depth < result.size(); depth++) {
            System.out.println("Link list at depth " + depth + ":");
            result.get(depth).forEach(n -> System.out.print(" " + n.data));
        }
    }


    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = null;
        List<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

    // another way to achieve the same is using the BFS on the tree
    private List<LinkedList<TreeNode>> createLevelLinkedListUsingBFS(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() != 0) {
            result.add(current); // this is where per level nodes are getting added as linked list to the result
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