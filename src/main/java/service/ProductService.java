package main.java.service;


import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.model.Product;
import main.java.model.ProductCategory;
import java.util.List;

public class ProductService {

    private static ProductService productService;

    private ProductService() {
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    /**
     * Add product in memory dao
     */
    public void addProduct(Product product) {
        ProductInMemoryDao.getEntity().addProduct(product);
    }

    /**
     * Update product in memory dao
     */
    public void updateProduct(Product product) {
        ProductInMemoryDao.getEntity().updateProduct(product);
    }

    /**
     * Get product by id
     *
     * @return found product by id
     */
    public Product getProductById(int productId) {
       return ProductInMemoryDao.getEntity().getProductById(productId);
    }

    /**
     * Get product by name
     *
     * @return list of product by name
     */
    public List<Product> getProductsByName(String name) {
        return ProductInMemoryDao.getEntity().getProductsByName(name);
    }

    /**
     * Get product by category
     *
     * @return list of product a category
     */
    public List<Product> getProductsByCategory(ProductCategory category) {
       return ProductInMemoryDao.getEntity().getProductsByCategory(category);
    }

    /**
     * Get all product.
     *
     * @return list of all products
     */
    public List<Product> getAllProducts() {
        return ProductInMemoryDao.getEntity().getAllProducts();
    }

    /**
     * Remove product in memory dao.
     */
    public void removeProduct(int productId) {
        ProductInMemoryDao.getEntity().removeProduct(productId);
    }

}
