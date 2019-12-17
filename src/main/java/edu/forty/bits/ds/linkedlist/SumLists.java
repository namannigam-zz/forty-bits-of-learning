package edu.forty.bits.ds.linkedlist;

/**
 * You have two numbers represented as a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum of the linked list.
 * (follow up: if the input is represented as forward order of digits)
 */
public class SumLists {

    // if the numbers are represented in the reverse order, they could be added with a carry towards
    // the next addition
    private LinkedListNode sumOfNumbers(LinkedListNode first, LinkedListNode second, int carry) {
        if (first == null && second == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (first != null) {
            value = first.data + carry;
        }
        if (second != null) {
            value = second.data + value;
        }
        result.data = value % 10;

        // recursion called here would end based on the null value check (both have been consumed)
        if (first != null || second != null) {
            result.next =
                    sumOfNumbers(
                            first == null ? first : first.next,
                            second == null ? second : second.next,
                            value / 10);
        }
        return result;
    }

    // if the input is revered to represent the forward order of digits
    // one way is to reverse the linked lists and then sum them as in previous approach
    private LinkedListNode sumOfNumbersInForwardOrder(
            LinkedListNode first, LinkedListNode second, int carry) {
        LinkedListNode l1 = ReverseLinkedList.reverseLinkedList(first);
        LinkedListNode l2 = ReverseLinkedList.reverseLinkedList(second);
        return sumOfNumbers(l1, l2, carry);
    }


    // follow up:-
    // another approach is to create a wrapper class like PartialSum and recurse with helper
    // while ensuring to create a head for carry with first digit sum and ending recursion when both
    // the node's point to null


    private static int length(LinkedListNode l) {
        return l == null ? 0 : 1 + length(l.next);
    }

    private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        PartialSum sum = addListsHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
        LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
        sum.sum = fullResult;
        sum.carry = val / 10;
        return sum;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListsHelper(l1, l2);
        return sum.carry == 0 ? sum.sum : insertBefore(sum.sum, sum.carry);
    }

    private static LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    // Just make sure inserted node is the head every time
    private static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        while (node != null) {
            value = value * 10 + node.data;
            node = node.next;
        }
        return value;
    }

    static class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }
}