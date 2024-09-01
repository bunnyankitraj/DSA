package org.FactoryInterview;


public class Main {

    public static void main(String[] args) {

        ProductFinder productFinder = new ProductFinderA();
        Product product = productFinder.createProduct();
        product.funProduct();
        product.runProduct();

        ProductFinder productFinderB = new ProductFinderB();
        Product productB = productFinderB.createProduct();
        productB.funProduct();
        productB.runProduct();
    }

}
