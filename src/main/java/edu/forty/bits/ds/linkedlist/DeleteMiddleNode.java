package edu.forty.bits.ds.linkedlist;

// given a node delete it from the middle
public class DeleteMiddleNode {

    // given just the node to delete and not the head of the linked list
    // this should be a simple node deletion ensuring the references are changed for the previous node
    // to the next node
    boolean deleteNodeInMiddle(LinkedListNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            return false;
        }
        // just make sure that the current node now reference to its next node
        LinkedListNode nextNode = nodeToDelete.next;
        nodeToDelete.data = nextNode.data;
        nodeToDelete.next = nextNode.next;
        return true;
    }
}
