package org.singleton;

public class Main {
    public static void main(String[] args) {
        // Get the only object available from the Singleton class.
        Singleton singletonInstance = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();

        // Call the method of the singleton instance.
        singletonInstance.showMessage();  // Output: Hello, I am a Singleton!
        singletonInstance2.showMessage();  // Output: Hello, I am a Singleton!
    }
}
