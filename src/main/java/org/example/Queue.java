package org.example;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue
    public Queue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1; // Returning -1 for underflow condition
        }
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    // Method to return the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // Returning -1 if queue is empty
        }
        return arr[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to return the current size of the queue
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element is: " + queue.peek()); // Output: 10

        queue.dequeue(); // Removes 10
        System.out.println("Front element after dequeue: " + queue.peek()); // Output: 20

        System.out.println("Queue size is: " + queue.size()); // Output: 4

        queue.dequeue(); // Removes 20
        queue.dequeue(); // Removes 30

        System.out.println("Queue size after 2 dequeues: " + queue.size()); // Output: 2

        queue.enqueue(60); // Adds 60 to the queue
        System.out.println("Front element after enqueue 60: " + queue.peek()); // Output: 40
    }
}
