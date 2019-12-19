package edu.forty.bits.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Consider a simple data structure called BiNode having two other node references.
 * The ds could be used to represent both a binary tree(left - node1, right - node2)
 * or a doubly linked list(prev-node1, next-node2). Implement a method to convert a binary tree
 * into a doubly linked list. The values should be kept in the order and the operation should be performed
 * in place(on original data structure).
 */
public class BiNodeTransformation {

    @Getter
    @AllArgsConstructor
    static class BiNode {
        BiNode node1;
        BiNode node2;
        int data;
    }

    // The approach could be to perform an In-Order traversal using recursion and updating the references.

    // Conversion of the above pseudo code is complex for this problem. There are multiple approaches possible for that.

    // One of these would be to keep a track of the head and the tail while converting the nodes of the tree.
    // This could be done without any additional data structure, but the following reads cleaner.

    @AllArgsConstructor
    private static class NodePair {
        BiNode head;
        BiNode tail;
    }

    public static NodePair convertNP(BiNode root) {
        if (root == null) {
            return null;
        }

        NodePair part1 = convertNP(root.node1);
        NodePair part2 = convertNP(root.node2);

        // this is inorder
        if (part1 != null) {
            concat(part1.tail, root);
        }
        if (part2 != null) {
            concat(root, part2.head);
        }

        return new NodePair(part1 == null ? root : part1.head, part2 == null ? root : part2.tail);
    }

    public static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

    // In the above approach, we could just return the head and create a utility to find the tail.
    // The complexity of the code though would be O(N*d) for each node being accessed d times at depth d
    // for N nodes above it. That results into O(N^2) solution.
    public static BiNode getTail(BiNode node) {
        if (node == null) {
            return null;
        }
        while (node.node2 != null) {
            node = node.node2;
        }
        return node;
    }

    public static BiNode convert(BiNode root) {
        if (root == null) {
            return null;
        }

        BiNode part1 = convert(root.node1);
        BiNode part2 = convert(root.node2);

        // this is inorder
        if (part1 != null) {
            concat(getTail(part1), root);
        }
        if (part2 != null) {
            concat(root, part2);
        }

        return part1 == null ? root : part1;
    }

    // To ease the tail and head relation, we can use circular linked list representation and
    // reduce the traversal to only oce for each node. That would give us a O(N) order complexity

    public static BiNode convertToCircular(BiNode root) {
        if (root == null) {
            return null;
        }

        BiNode part1 = convertToCircular(root.node1);
        BiNode part3 = convertToCircular(root.node2);

        if (part1 == null && part3 == null) {
            root.node1 = root;
            root.node2 = root;
            return root;
        }
        BiNode tail3 = part3 == null ? null : part3.node1;

        /* join left to root */
        if (part1 == null) {
            concat(part3.node1, root);
        } else {
            concat(part1.node1, root);
        }

        /* join right to root */
        if (part3 == null) {
            concat(root, part1);
        } else {
            concat(root, part3);
        }

        /* join right to left */
        if (part1 != null && part3 != null) {
            concat(tail3, part1);
        }

        return part1 == null ? root : part1;
    }

    public static BiNode convertC(BiNode root) {
        BiNode head = convertToCircular(root);
        head.node1.node2 = null;
        head.node1 = null;
        return head;
    }
}