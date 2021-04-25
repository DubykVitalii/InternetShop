package main.java.dao.inmemorydb;

import main.java.dao.ProductDao;
import main.java.model.Product;
import main.java.model.ProductCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductInMemoryDao implements ProductDao {
    private final Set<Product> products = new HashSet<>();
    private static ProductDao entity;

    private ProductInMemoryDao() {
    }

    public static ProductDao getEntity() {
        if (entity == null) {
            entity = new ProductInMemoryDao();
        }
        return entity;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        removeProduct(product.getId());
        products.add(product);
    }

    @Override
    public Product getProductById(String productId) {
        var optionalUser = products.stream()
                .filter(productModel -> productModel.getId().equals(productId))
                .findFirst();
        return optionalUser.orElse(null);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        if (products.stream().anyMatch(userModel -> userModel.getName().contains(name))) {
            return products.stream().filter(userModel -> userModel.getName().equals(name))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        if (products.stream().anyMatch(userModel -> userModel.getCategory().equals(category))) {
            return products.stream().filter(userModel -> userModel.getCategory().equals(category))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void removeProduct(String productId) {
        if (isProductInDatabase(productId)) {
            products.remove(getProductById(productId));
        }
    }

    private boolean isProductInDatabase(String productId) {
        return products.stream().anyMatch(product -> product.getId().equals(productId));
    }
}