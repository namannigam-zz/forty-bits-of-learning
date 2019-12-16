package edu.forty.bits.ds.linkedlist;

/**
 * Created by naman.nigam on 09/02/16.
 */
class ReverseLinkedList {

    // reverses without using any extra space
    static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    static LinkedListNode reverseLinkedListAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode next = new LinkedListNode(node.data);
            next.next = node;
            head = next;
            node = node.next;
        }
        return head;
    }
}
