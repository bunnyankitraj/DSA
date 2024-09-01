package org.FactoryInterview;

public class ProductFinderB extends ProductFinder{
    @Override
    Product createProduct() {
        return new ProductB();
    }
}
