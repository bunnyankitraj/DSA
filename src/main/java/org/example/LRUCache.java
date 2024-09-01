package org.example;

import java.util.HashMap;
import java.util.Map;

class ListNodes {
    int key;
    int value;
    ListNodes next;
    ListNodes prev;

    public ListNodes(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    Map<Integer, ListNodes> map = new HashMap<>();
    int capacity;
    ListNodes head;
    ListNodes tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public void put(int key, int value) {
        ListNodes node = map.get(key);

        if (node != null) {
            // Update the value and move node to the head
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                // Remove the tail node
                map.remove(tail.key);
                removeNode(tail);
            }
            // Add new node to the head
            ListNodes newNode = new ListNodes(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    private void addNode(ListNodes node) {
        if (head == null) {
            // If the list is empty, initialize head and tail
            head = node;
            tail = node;
        } else {
            // Add node before the head
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void removeNode(ListNodes node) {
            if (node == tail) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            ListNodes prev = node.prev;
            ListNodes next = node.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    private void moveToHead(ListNodes node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        ListNodes node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    private void printAll() {
        ListNodes current = head;
        while (current != null) {
            System.out.println("[" + current.key + ", " + current.value + "]");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));  // returns 1
        lruCache.put(3, 3);  // evicts key 2
        System.out.println(lruCache.get(2));  // returns -1 (not found)
        lruCache.put(4, 4);  // evicts key 1
        System.out.println(lruCache.get(1));  // returns -1 (not found)
        System.out.println(lruCache.get(3));  // returns 3
        System.out.println(lruCache.get(4));  // returns 4
        lruCache.printAll();  // prints the current state of the cache
    }
}
