package org.strageyPattern;

// The Context class uses a Strategy object to execute a particular algorithm.
public class Context {
    private Strategy strategy;

    // The constructor allows the strategy to be set at runtime.
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // The workStrategy method uses the strategy to perform the operation.
    public int workStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

    // A setter to change the strategy at runtime if needed.
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executePrint(int num1, int num2) {
        strategy.printNumber(num1,num2);
    }
}
