package org.singleton;

public class Singleton {
    // The private static instance of the class is declared but not initialized yet.
    private static volatile Singleton instance = null;

    // The constructor is private to prevent instantiation from other classes.
    private Singleton() {
        // Optional: Initialize any resources or variables here
    }

    // Public static method to provide access to the single instance of the class.
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            // Introduce a 5-second delay whenever the instance is accessed.
            try {
                System.out.println("Lock acquired. Please wait for 5 seconds...");
                Thread.sleep(5000);  // 5-second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Double-checked locking to ensure thread safety.
            if (instance == null) {
                instance = new Singleton();
                System.out.println("Singleton instance created.");
            } else {
                System.out.println("Singleton instance accessed.");
            }
        }
        return instance;
    }

    // Example method to demonstrate functionality.
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
}
