package org.factoryPattern.impl;

import org.factoryPattern.Product;

public class ConcreteProductB implements Product {
    @Override
    public void show() {
        System.out.println("This is ConcreteProductB");
    }

    @Override
    public void print() {
        System.out.println("printing ConcreteProductB");
    }
}