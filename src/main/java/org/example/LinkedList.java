//package org.example;
//
//import java.util.*;
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    public ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}
//
//public class LinkedList {
//    private ListNode head;
//
//    public LinkedList() {
//        this.head = null;
//    }
//
//    public void add(int val) {
//        ListNode newNode = new ListNode(val);
//        if (head == null) {
//            head = newNode;
//        } else {
//            ListNode current = head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newNode;
//        }
//    }
//
//    public void removeLast() {
//        if (head == null || head.next == null) {
//            head = null;
//        } else {
//            ListNode prev = null;
//            ListNode current = head;
//            while (current.next != null) {
//                prev = current;
//                current = current.next;
//            }
//            prev.next = null;
//        }
//    }
//
//    public void remove(int val) {
//        if (head == null) {
//            return;
//        }
//        if (head.val == val) {
//            head = head.next;
//            return;
//        }
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null && current.val != val) {
//            prev = current;
//            current = current.next;
//        }
//        if (current != null) {
//            prev.next = current.next;
//        }
//    }
//
//    public void traverseAndPrint() {
//        ListNode current = head;
//        while (current != null) {
//            System.out.print(current.val + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public void reverse() {
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode nextNode = null;
//        while (current != null) {
//            nextNode = current.next;
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//        }
//        head = prev;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = Integer.parseInt(scanner.nextLine());
//
//        LinkedList linkedList = new LinkedList();
//        for (int i = 0; i < N; i++) {
//            String[] operation = scanner.nextLine().split("\\s+");
//            switch (operation[0]) {
//                case "add": {
//                    int val = Integer.parseInt(operation[1]);
//                    linkedList.add(val);
//                    break;
//                }
//                case "remove": {
//                    int val = Integer.parseInt(operation[1]);
//                    linkedList.remove(val);
//                    break;
//                }
//                case "traverse":
//                    linkedList.traverseAndPrint();
//                    break;
//                case "reverse":
//                    linkedList.reverse();
//                    break;
//            }
//        }
//
//        scanner.close();
//    }
//}
//
