package org.FactoryInterview;

public class ProductA implements Product {
    @Override
    public void runProduct() {
        System.out.println("ProductA runProduct");
    }

    @Override
    public void funProduct() {
        System.out.println("ProductA funProduct");
    }
}
