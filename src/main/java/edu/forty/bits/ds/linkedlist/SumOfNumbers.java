package edu.forty.bits.ds.linkedlist;

// find the sum of two numbers represented as digits in reverse order of linked list
// (then follow up if the input is represented as forward order of digits)
public class SumOfNumbers {

    // if the numbers are represented in the reverse order, they could be added with a carry towards the next addition
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

        if (first != null || second != null) {
            result.next = sumOfNumbers(first == null ? first : first.next,
                    second == null ? second : second.next, value / 10);
        }
        return result;
    }

    // if the input is revered to represent the forward order of digits
    // one way is to reverse the linked lists and then sum them as in previous approach
    private LinkedListNode sumOfNumbersInForwardOrder(LinkedListNode first, LinkedListNode second, int carry) {
        LinkedListNode l1 = ReverseLinkedList.reverseLinkedList(first);
        LinkedListNode l2 = ReverseLinkedList.reverseLinkedList(second);
        return sumOfNumbers(l1, l2, carry);
    }


    // another approach is to create a wrapper class like PartialSum and recurse with helper
    // while ensuring to create a head for carry with first digit sum and ending recurstion when both the node's point to null
}