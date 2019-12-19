package edu.forty.bits.datastructures.linkedlist;

public class LinkedListNode {
    public LinkedListNode next;
    int data;

    public LinkedListNode() {
    }

    // Constructor to create a new node
    LinkedListNode(int d) {
        data = d;
        next = null;
    }
}
