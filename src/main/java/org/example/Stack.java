//package org.example;
//
//public class Stack {
//    private int[] arr;
//    private int top;
//    private int capacity;
//
//    public Stack(){
//        capacity = n;
//        arr= new int[capacity];
//        top=-1;
//    }
//
//    public int push(int element){
//        if(top-1==capacity) return -1;
//        top++;
//        arr[top] = element;
//        return element;
//    }
//
//    public void pop(){
//        if(top==-1) return;
//        top--;
//    }
//
//    public int peek(){
//        return arr[top];
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }
//
//    public int size() {
//        return top + 1;
//    }
//
//    public static void main(String[] args) {
//        Stack stack = new Stack();
//        System.out.println(stack.push(9));
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        stack.pop();
//        System.out.println(stack.isEmpty());
//    }
//}
