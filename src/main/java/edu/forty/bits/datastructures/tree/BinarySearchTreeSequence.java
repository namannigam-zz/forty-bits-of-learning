package edu.forty.bits.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 */
public class BinarySearchTreeSequence {

    // A pre-order traversal of the tree could list down all the elements in one sequence.
    // But the problem is the greater the depth there are further chances of introducing an element from
    // depth 4 before an element from depth 3 was introduced.

    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                  List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add the remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the
         * head will damage first, so we’ll need to put it back where we
         * found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring
         * the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }


    // recurse for the sequences possible considering one node as the root
    public static List<LinkedList<Integer>> allSequences(TreeNode node) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        /* Recurse on left and right subtrees. */
        List<LinkedList<Integer>> leftSeq = allSequences(node.left);
        List<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        List<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }
}