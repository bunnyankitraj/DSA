package org.FactoryInterview;

public class ProductB implements Product {
    @Override
    public void runProduct() {
        System.out.println("ProductB runProduct");
    }

    @Override
    public void funProduct() {
        System.out.println("ProductB funProduct");
    }
}
