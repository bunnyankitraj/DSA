package org.factoryPattern;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Factory class.
        Factory factory = new Factory();

        // Use the factory to create objects of ConcreteProductA and ConcreteProductB.
        Product productA = factory.createProduct("A");
        Product productB = factory.createProduct("B");

        // Call the show method on the created products.
        if (productA != null) {
            productA.show(); // Output: This is ConcreteProductA
            productA.print();
        }
        if (productB != null) {
            productB.show(); // Output: This is ConcreteProductB
            productB.print();
        }
    }
}
