package edu.forty.bits.datastructures.linkedlist;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and build a "least recently used" cache, which evicts the least recently used item.
 * The cache should map from keys to values (allowing you to insert and retrieve a value
 * associated with a particular key) and be initialised with a max size. When it is full, it should evict the
 * least recently used item.
 */
public class LRUCache {

    // We can implement an LRU using a TreeMap with lastUsed time as its key and item as its value,
    // but while adding a value to the map we would have to ensure that if an entry exist such that
    // the value is already present, we should then not update the map, else delete the first map entry (if full)
    // create a new entry (if not full). Similarly while performing a get of a value,
    // we would have to update the key of this map. But this would become more complex for lookups and
    // hence we should simplify by using our own data structure.


    // Listing down all possible operations that we can perform on the cache would be a good way to start.
    // - We would need to insert a key value
    // - Retrieve value by key
    // - Find least recently used value
    // - Update the most recently used value
    // - Eviction (remove least recently used based on capacity)


    // Representation as a hash table simplifies lookups. Representing the data as a linked list with
    // most frequently used as head to least frequently used as tail,
    // simplifies insert and remove but does not solve the problem of finding the item by its key easily.

    // A combination of both the above can help is solving for all, insert, delete and get. But remember,
    // we would be using doubly linked lists for removal of a middle element.

    @Getter
    static class Cache {
        private int maxCacheSize;
        private Map<Integer, LinkedListNode> map = new HashMap<>();
        private LinkedListNode listHead = null;
        private LinkedListNode listTail = null;

        public Cache(int maxCacheSize) {
            this.maxCacheSize = maxCacheSize;
        }

        // Get value for key and mark as most recently used.
        public String getValue(int key) {
            LinkedListNode item = map.get(key);
            if (item == null) {
                return null;
            }

            // Move to front of list to mark as most recently used.
            if (item != listHead) {
                removeFromLinkedList(item);
                insertAtFrontOfLinkedList(item);
            }
            return item.value;
        }

        // Remove node from linked list.
        private void removeFromLinkedList(LinkedListNode node) {
            if (node == null) {
                return;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == listTail) {
                listTail = node.prev;
            }
            if (node == listHead) {
                listHead = node.next;
            }
        }

        // Insert node at front of linked list.
        private void insertAtFrontOfLinkedList(LinkedListNode node) {
            if (listHead == null) {
                listHead = node;
                listTail = node;
            } else {
                listHead.prev = node;
                node.next = listHead;
                listHead = node;
                listHead.prev = null;
            }
        }

        // Remove key, value pair from cache, deleting from hash table and linked list. */
        public void removeKey(int key) {
            removeFromLinkedList(map.remove(key));
        }

        // Put key, value pair in cache. Removes old value for key if necessary.
        // Inserts pair into linked list and hash table.
        public void setKeyValue(int key, String value) {
            // Remove if already there.
            removeKey(key);

            // If full, remove least recently used item from cache.
            if (map.size() >= maxCacheSize && listTail != null) {
                removeKey(listTail.key);
            }

            // Insert new node.
            LinkedListNode node = new LinkedListNode(key, value);
            insertAtFrontOfLinkedList(node);
            map.put(key, node);
        }

        public String getCacheAsString() {
            if (listHead == null) return "";
            return listHead.printForward();
        }

        private static class LinkedListNode {
            LinkedListNode next;
            LinkedListNode prev;
            int key;
            String value;

            public LinkedListNode(int k, String v) {
                key = k;
                value = v;
            }

            public String printForward() {
                String data = "(" + key + "," + value + ")";
                if (next != null) {
                    return data + "->" + next.printForward();
                } else {
                    return data;
                }
            }
        }
    }
}