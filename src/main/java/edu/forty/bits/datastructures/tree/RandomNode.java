package edu.forty.bits.datastructures.tree;

import java.util.Random;

/**
 * You are implementing a binary tree class from scratch which, in addition to insert, find, and delete has
 * a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be
 * chosen. Design and implement and algorithm for getRandomNode, and explain how you would implement the rest of
 * the methods.
 */
public class RandomNode {

    // one of the ways could have been to create a list and update it with every insert to use it while getting
    // random node, but this would be costly to maintain during the time of node deletion


    // another way could have been traversing to a random depth and finding a node their to get random value, but the
    // challenge there would be to ensure existence of nodes at a given orr selected depth

    // an approach of choosing a node with a probability of 1/N from a trees, to define the probability of a
    // left node and right node, one would have to determine the size of the subtree and update it with insertion
    // and deletion of the nodes in the tree

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        private int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public void insertInOrder(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new TreeNode(d);
                } else {
                    left.insertInOrder(d);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }

        public int size() {
            return size;
        }

        public TreeNode find(int d) {
            if (d == data) {
                return this;
            } else if (d <= data) {
                return left != null ? left.find(d) : null;
            }
            return right != null ? right.find(d) : null;
        }

        public TreeNode getRandomNode() {
            int leftSize = left == null ? 0 : left.size();
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        public TreeNode getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size();
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSize + 1));
            }
        }
    }

    TreeNode root = null;

    public void insertInOrder(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }

    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            RandomNode tree = new RandomNode();
            int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
            for (int x : array) {
                tree.insertInOrder(x);
            }
            int d = tree.getRandomNode().data;
            counts[d]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}