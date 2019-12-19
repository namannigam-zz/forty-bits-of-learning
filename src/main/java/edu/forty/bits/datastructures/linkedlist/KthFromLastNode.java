package edu.forty.bits.datastructures.linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class KthFromLastNode {

    // can ask if the list size is known, recursive vs iterative solution
    // this is just a util to get the Kth element in the list
    static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    // one way is to find the size of the list and then traverse again to find the 'size -k' element,
    // this would be O(2n -k) but precisely O(n)
    // another approach is to keep a runner at k difference from head, when this pointer reaches the end,
    // slow pointer would be at the desired node
    LinkedListNode kthFromLastNodeRunner(LinkedListNode head, int k) {
        LinkedListNode fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // out of bounds
            }
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    // recursive approach (just to print the element, not return it)
    // one can return element from within the recursion as well, but the complexity of code increases
    int kthFromLastNodeRecursive(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = kthFromLastNodeRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + " to the last node is " + head.data);
        }
        return index;
    }
}