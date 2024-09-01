package org.strageyPattern;

import org.strageyPattern.impl.ConcreteStrategyAdd;
import org.strageyPattern.impl.ConcreteStrategyMultiply;
import org.strageyPattern.impl.ConcreteStrategySubtract;

public class Main {
    public static void main(String[] args) {
        // Create a Context object and set it to use the addition strategy.
        Context context = new Context(new ConcreteStrategyAdd());
        System.out.println("10 + 5 = " + context.workStrategy(10, 5)); // Output: 10 + 5 = 15
        context.executePrint(10,5);
//        context.justChilling();

        // Change the strategy to subtraction.
        context.setStrategy(new ConcreteStrategySubtract());
        System.out.println("10 - 5 = " + context.workStrategy(10, 5)); // Output: 10 - 5 = 5
        context.executePrint(10,5);

        // Change the strategy to multiplication.
        context.setStrategy(new ConcreteStrategyMultiply());
        System.out.println("10 * 5 = " + context.workStrategy(10, 5)); // Output: 10 * 5 = 50
        context.executePrint(10,5);
    }

}
