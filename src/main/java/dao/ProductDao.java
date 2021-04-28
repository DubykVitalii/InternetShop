package main.java.dao;

import main.java.model.Product;
import main.java.model.ProductCategory;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    void updateProduct(Product product);

    Product getProductById(int productId);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByCategory(ProductCategory category);

    List<Product> getAllProducts();

    void removeProduct(int productId);

}
