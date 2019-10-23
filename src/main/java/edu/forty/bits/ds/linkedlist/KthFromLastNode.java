package org.practice.learning.linkedlist;

// can ask if the list size is known, recursive vs iterative solution
public class KthFromLastNode {

    // one way is to find the size of the list and then traverse again to find the 'size -k' element,
    // this would be O(n) but precisely O(n)
    // another approach is to keep a runner at k difference from head, when this pointer reaches the end,
    // slow pointer would be at the desired node
    LinkedListNode KthFromLastNodeRunner(LinkedListNode head, int k) {
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
    int KthFromLastNodeRecursive(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = KthFromLastNodeRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + " to the last node is " + head.data);
        }
        return index;
    }


    // this is just a util to get the Kth element in the list
    static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}