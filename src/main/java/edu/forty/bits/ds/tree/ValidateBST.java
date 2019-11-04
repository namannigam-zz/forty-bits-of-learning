package edu.forty.bits.ds.tree;

import java.util.stream.IntStream;

// this is to check if a given Binary tree is a Binary Search tree or not.
public class ValidateBST {

    private int index = 0;

    private void copyBST(TreeNode root, int[] array) {
        if (root == null) return;
        copyBST(root.left, array);
        array[index] = root.data;
        index++;
        copyBST(root.right, array);
    }

    // there are two possible approaches with this,
    // one is to do an in-order traversal and copying the elements into an array, then ensuring that the array is sorted
    // this takes up around O(N + N) runtime N, for each part and the space required for this is also, O(N)
    boolean checkBST(TreeNode root) {
        int[] values = new int[100]; // use 'root.size' implementation
        copyBST(root, values);
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) return false;
        }
        return true;
    }

    boolean checkBSTStream(TreeNode root) {
        int[] values = new int[100]; // use 'root.size' implementation
        copyBST(root, values);
        return IntStream.range(1, values.length).noneMatch(i -> values[i - 1] > values[i]);
    }


    // as noticeable, the primary check here is to compare an element with the element added previous to it in array
    // so we could modify the existing solution to reduce the space consumed as
    private Integer last_printed = null;

    private boolean checkBSTOptimised(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!checkBSTOptimised(root.left)) {
            return false;
        }
        if (last_printed != null && root.data <= last_printed) {
            return false;
        }
        last_printed = root.data;
        return checkBSTOptimised(root.right); // final check
    }


    // another way to approach the problem is to simply compare the data based on the condition left <= data < right
    // but the challenge with this is that the condition should hold true for the entire subtree within a node
    boolean checkBSTWithMinMax(TreeNode node) {
        return checkBSTWithMinMax(node, null, null);
    }

    private boolean checkBSTWithMinMax(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.data <= min) || (max != null && node.data > max)) {
            return false;
        }
        return (checkBSTWithMinMax(node.left, min, node.data)) && checkBSTWithMinMax(node.right, node.data, max);
    }
}