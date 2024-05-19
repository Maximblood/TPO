package model;

import java.util.Objects;

public class Product {
    private String product_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String title) {
        this.product_name = title;
    }

    public Product(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name ='" + product_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(product_name, product.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_name);
    }
}
