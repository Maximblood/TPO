package service;

import model.Product;

public class ProductCreator {
    public static final String TEST_DATA = "testdata.product.product_name";

    public static Product withTitleFromProperty(){
        return new Product(TestDataReader.getTestData(TEST_DATA));
    }

    public static Product withTitle(){
        return new Product("ноутбук");
    }

    public static Product withEmptyProductName(){
        return new Product("");
    }
}
