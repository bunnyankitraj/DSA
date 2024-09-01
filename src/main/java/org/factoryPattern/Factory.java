package org.factoryPattern;

import org.factoryPattern.impl.ConcreteProductA;
import org.factoryPattern.impl.ConcreteProductB;

// The Factory class is responsible for creating objects of ConcreteProductA and ConcreteProductB.
public class Factory {
    // The createProduct method takes a string as input and returns a Product object based on the input.
    public Product createProduct(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ConcreteProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ConcreteProductB();
        }
        return null; // Return null if the input does not match any known product type.
    }
}
