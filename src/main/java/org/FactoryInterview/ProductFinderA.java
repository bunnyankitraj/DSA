package org.FactoryInterview;

public class ProductFinderA extends ProductFinder {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}
