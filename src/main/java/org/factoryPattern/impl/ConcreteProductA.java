package org.factoryPattern.impl;

import org.factoryPattern.Product;

public class ConcreteProductA implements Product {
    @Override
    public void show() {
        System.out.println("This is ConcreteProductA");
    }

    @Override
    public void print() {
        System.out.println("printing  ConcreteProductA");
    }
}