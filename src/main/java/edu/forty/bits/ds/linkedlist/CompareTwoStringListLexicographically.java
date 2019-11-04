package edu.forty.bits.ds.linkedlist;

import java.util.LinkedList;

/** @link {http://www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists} */
public class CompareTwoStringListLexicographically {

  public static void compareLinkedList(
      LinkedList<String> linkedList1, LinkedList<String> linkedList2) {
    if (linkedList1.size() > linkedList2.size()) {
      System.out.println("1");
    } else if (linkedList2.size() > linkedList1.size()) {
      System.out.println("-1");
    } else {
      int i = 0;
      while (i < linkedList1.size()) {
        CompareTwoStringListLexicographically.compare(
            linkedList1.get(i).charAt(0), linkedList2.get(i).charAt(0));
        i++;
      }
    }
  }

  private static void compare(Character a, Character b) {
    if (a == b) {
      System.out.println("Result is :  0. String " + a + " is lexiographically equal to " + b);
    } else if (a > b) {
      System.out.println("Result is :  1. String " + a + " is lexiographically greater than " + b);
    } else {
      System.out.println("Result is : -1. String " + b + " is lexiographically greater than " + a);
    }
  }

  int compare(LinkedListNode linkedListNode1, LinkedListNode linkedListNode2) {

    if (linkedListNode1 == null && linkedListNode2 == null) {
      return 0;
    }
    while (linkedListNode1 != null
        && linkedListNode2 != null
        && linkedListNode1.data == linkedListNode2.data) {
      linkedListNode1 = linkedListNode1.next;
      linkedListNode2 = linkedListNode2.next;
    }

    // if the list are diffrent in size
    if (linkedListNode1 != null && linkedListNode2 != null) {
      return (linkedListNode1.data > linkedListNode2.data ? 1 : -1);
    }

    // if either of the list has reached end
    if (linkedListNode1 != null && linkedListNode2 == null) {
      return 1;
    }
    if (linkedListNode1 == null && linkedListNode2 != null) {
      return -1;
    }
    return 0; // covers the case when both the node1 and node2 have ended up with NULL (same
              // strings)
  }
}
