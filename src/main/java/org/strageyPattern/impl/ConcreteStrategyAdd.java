package org.strageyPattern.impl;

import org.strageyPattern.Strategy;

// ConcreteStrategyAdd implements the Strategy interface and defines the addition operation.
public class ConcreteStrategyAdd implements Strategy {
    @Override
    public void printNumber(int num1, int num2) {
        System.out.println("printing ConcreteStrategyAdd num1 and num2 " + num1 + " " + num2);
    }

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
