package edu.forty.bits.ds.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Consider a simple data structure called BiNode having two other node references.
 * The ds could be used to represent both a binary tree(left - node1, right - node2)
 * or a doubly linked list(prev-node1, next-node2). Implement a method to convert a binary tree
 * into a doubly linked list. The values should be kept in the orrderr and the operation should be performed
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
}