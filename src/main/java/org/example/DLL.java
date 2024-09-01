package org.example;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}


public class DLL {

    int[] arr = new int[5];

    public DLL() {
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
    }

    static Node createDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < 5; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static Node deleteHead1(Node head) {
        if (head == null || head.next == null) return null;  // Handle null and single-node list
        Node newHead = head;
        head = head.next;
        head.prev = null;
        newHead.next = null;
        return head;
    }

    static Node deleteHead2(Node head) {
        if (head == null || head.next == null) return null;  // Handle null and single-node list

        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;  // Detach the original head
        return newHead;
    }

    static void printLinkedList(Node ans) {
        System.out.println("New Print");

        while (ans != null) {
            System.out.println(ans.data);
            ans = ans.next;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        Node head = dll.createDLL(dll.arr);
        int k = 2;
//        printLinkedList(head);
//        printLinkedList(deleteHead2(head));
//        printLinkedList(deleteHead1(head));
//        printLinkedList(deleteTail(head));
        printLinkedList(deleteKthElement(head,k));
    }

    private static Node deleteKthElement(Node head, int k) {
        Node temp = head;
        int cnt =0;
        while(temp!=null){
            cnt++;
            if(k==cnt){
                break;
            }
            temp=temp.next;
        }
        Node before = temp.prev ;
        Node after = temp.next;
        before.next = after;
        after.prev = before;
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;  // Handle null and single-node list

        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node last = temp.prev;
        last.next = null;
        temp.prev=null;
        return head;
    }
}
