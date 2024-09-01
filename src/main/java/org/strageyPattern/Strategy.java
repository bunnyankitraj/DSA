package org.strageyPattern;

// The Strategy interface defines the method that each concrete strategy must implement.
public abstract interface Strategy {

    void printNumber(int num1,int num2);

    int doOperation(int num1, int num2);

    default void justChilling(){
        System.out.println("why you call default");
    }

//    abstract void justChillingAbstract(){
//        System.out.println("why you call me");
//    }
}
