package edu.forty.bits.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * (how would you do this without a temporary buffer)
 */
public class RemoveDuplicateNodes {

    // consider a single linked list of integers for the example, the solution to iterate over
    // the linked list would take O(n) runtime, where n is the number of nodes.
    void removeDupes(LinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode prev = head; // use for deleting the links in a single linked list
        while (head != null) {
            if (set.contains(head.data)) {
                // deleteNode
                prev.next = head.next;
            } else {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    // we can run two pointers, the runner checks across all the linked list elements for subsequent duplicates
    // this would save space but would result in O(n^2) runtime
    void deleteDupesWithoutBuffer(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            // just to optimise a bit , the runner should always look forward
            // safely assuming that the duplicates for previous have already been checked
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}