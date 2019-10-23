package org.practice.learning.linkedlist;

public class CustomLinkedList {
    LinkedListNode head;

    public static int sizeOfList(LinkedListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void printList(LinkedListNode listHead) {
        if (listHead == null) {
            return;
        }
        System.out.print("LinkedList : ");
        while (listHead.next != null) {
            System.out.print(listHead.data + " -> ");
            listHead = listHead.next;
        }
        System.out.println(listHead.data);
    }

    public CustomLinkedList insert(CustomLinkedList list, int data) {
        // Create a new node with given data
        LinkedListNode new_node = new LinkedListNode(data);
        new_node.next = null;

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node  and insert the new_node there
            LinkedListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }
}