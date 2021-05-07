package main.java.model;

import java.util.Objects;

public class Product {
    private static int count = 0;

    private int productId;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(String name, double price, ProductCategory category) {
        this.productId = count++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "\nProduct ID:" + productId +
                ", Name:" + name + '\'' +
                ", Price:" + price + '\'' +
                ", Category:" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == (product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
