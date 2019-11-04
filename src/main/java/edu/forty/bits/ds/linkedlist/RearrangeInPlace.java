package edu.forty.bits.ds.linkedlist;

/**
 * @link {http://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place}
 */
public class RearrangeInPlace {

    public static void rearrange(LinkedListNode head) {
        /*
         * Find the middle point using tortoise and hare method
         */
        LinkedListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*
         * Split the linked list in two halves
         * LinkedListNode1, head of first half    1 -> 2 -> 3
         * LinkedListNode2, head of second half   4 -> 5
         */
        LinkedListNode linkedListLinkedListNode1 = head;
        LinkedListNode linkedListLinkedListNode2 = slow.next;
        slow.next = null;

        // Reverse the second half, i.e., 5 -> 4
        linkedListLinkedListNode2 = ReverseLinkedList.reverseLinkedList(linkedListLinkedListNode2);

        //  Merge alternate LinkedListNodes
        head = new LinkedListNode(0); // Assign dummy LinkedListLinkedListNode

        /*
         * curr is the pointer to this dummy LinkedListLinkedListNode, which will
         * be used to form the new list
         */
        LinkedListNode current = head;
        while (linkedListLinkedListNode1 != null || linkedListLinkedListNode2 != null) {
            // First add the element from first list
            if (linkedListLinkedListNode1 != null) {
                current.next = linkedListLinkedListNode1;
                current = current.next;
                linkedListLinkedListNode1 = linkedListLinkedListNode1.next;
            }

            // Then add the element from second list
            if (linkedListLinkedListNode2 != null) {
                current.next = linkedListLinkedListNode2;
                current = current.next;
                linkedListLinkedListNode2 = linkedListLinkedListNode2.next;
            }
        }

        // Assign the head of the new list to head pointer
        head = head.next;
        System.out.println("Linked List Rearranged In Place!");
    }
}