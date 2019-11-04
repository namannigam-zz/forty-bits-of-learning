package edu.forty.bits.ds.linkedlist;

public class LinkedListNode {
  public LinkedListNode next;
  int data;

  public LinkedListNode() {}

  // Constructor to create a new node
  LinkedListNode(int d) {
    data = d;
    next = null;
  }
}
