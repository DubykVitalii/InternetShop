package main.java.service;

import main.java.model.*;

// Make it singleton
public class AdminService {
    private static AdminService adminService;

    public static AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminService();
        }
        return adminService;
    }

    private AdminService() {
    }

    public void makeAdmin(User user) {
        user.setUserRole(UserRole.ADMIN);
    }

    public Order changeOrderStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
        return order;
    }

    public void blockUser(User user) {
        user.setIsActive(false);
    }

    public void unBlockUser(User user) {
        user.setIsActive(true);
    }

    public Product createProduct(String name, double price, int amountInStock, ProductCategory category) {
        return new Product(name, price, amountInStock, category);
    }

    public void showInfoAboutProduct(Product product) {
        System.out.println(product.toString());
    }

    public void updateProduct(Product product, String newName, double newPrice, int newAmountInStock, ProductCategory newCategory) {
        product.setName(newName);
        product.setPrice(newPrice);
        product.setAmountInStock(newAmountInStock);
        product.setCategory(newCategory);
    }

}
