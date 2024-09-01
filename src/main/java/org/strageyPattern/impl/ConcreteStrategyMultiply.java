package org.strageyPattern.impl;

import org.strageyPattern.Strategy;

// ConcreteStrategyAdd implements the Strategy interface and defines the addition operation.
public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public void printNumber(int num1, int num2) {
        System.out.println("printing ConcreteStrategyMultiply num1 and num2 " + num1 + " " + num2);
    }
}
