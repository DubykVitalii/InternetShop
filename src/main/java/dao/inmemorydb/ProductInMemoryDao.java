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
        Product milk = new Product("Milk", 20, 20, ProductCategory.FOOD);
        Product water = new Product("Water", 10, 50, ProductCategory.FOOD);
        Product honey = new Product("Honey", 125, 20, ProductCategory.FOOD);
        Product apple = new Product("Apple", 25, 50, ProductCategory.FOOD);
        Product tomato = new Product("Tomato", 22, 20, ProductCategory.FOOD);
        Product meat = new Product("Meat", 150, 50, ProductCategory.FOOD);
        Product beef = new Product("Beef", 200, 20, ProductCategory.FOOD);
        Product iPhone = new Product("iPhone12", 20000, 20, ProductCategory.GADGETS);
        Product asus_laptop_x500 = new Product("Asus Laptop x500", 200, 20, ProductCategory.GADGETS);
        Product jackDaniels = new Product("Jack Daniels", 500, 20, ProductCategory.ALCOHOL);
        products.add(milk);
        products.add(water);
        products.add(honey);
        products.add(apple);
        products.add(tomato);
        products.add(meat);
        products.add(beef);
        products.add(iPhone);
        products.add(asus_laptop_x500);
        products.add(jackDaniels);
    }

    public static ProductDao getEntity() {
        if (entity == null) {
            entity = new ProductInMemoryDao();
        }
        return entity;
    }

    /**
     * Add product in memory dao
     */
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Update product in memory dao
     */
    @Override
    public void updateProduct(Product product) {
        removeProduct(product.getId());
        products.add(product);
    }

    /**
     * Get product by id
     *
     * @return found product by id
     */
    @Override
    public Product getProductById(int productId) {
        var optionalUser = products.stream()
                .filter(productModel -> productModel.getId() == productId)
                .findFirst();
        return optionalUser.orElse(null);
    }

    /**
     * Get product by name
     *
     * @return list of product by name
     */
    @Override
    public List<Product> getProductsByName(String name) {
        if (products.stream().anyMatch(userModel -> userModel.getName().contains(name))) {
            return products.stream().filter(userModel -> userModel.getName().equals(name))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Get product by category
     *
     * @return list of product a category
     */
    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        if (products.stream().anyMatch(userModel -> userModel.getCategory().equals(category))) {
            return products.stream().filter(userModel -> userModel.getCategory().equals(category))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Get all product.
     *
     * @return list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Remove product in memory dao.
     */
    @Override
    public void removeProduct(int productId) {
        if (isProductInDatabase(productId)) {
            products.remove(getProductById(productId));
        }
    }

    /**
     * Product availability check
     *
     * @return boolean
     */
    private boolean isProductInDatabase(int productId) {
        return products.stream().anyMatch(product -> product.getId() == (productId));
    }

}