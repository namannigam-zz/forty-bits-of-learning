package edu.forty.bits.ds.linkedlist;

public class LinkedListNode {
    int data;
    public LinkedListNode next;

    public LinkedListNode() {
    }

    // Constructor to create a new node
    LinkedListNode(int d) {
        data = d;
        next = null;
    }
}