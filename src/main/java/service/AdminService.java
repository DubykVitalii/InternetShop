package main.java.service;

import main.java.dao.inmemorydb.OrderInMemoryDao;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.*;

import java.util.List;

public class AdminService {
    private static AdminService adminService;

    public static AdminService getInstance() {
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

    public void showListOfSubmittedOrders() {
        List<Order> orders = OrderInMemoryDao.getEntity().getAllOrders();

        for(Order order: orders){
            System.out.println(order.toString());
        }
    }

    public void showListOfUsers(){
        List<User> users = UserInMemoryDao.getEntity().getAllUsers();

        for(User user: users){
            System.out.println(user.toString());
        }
    }

}
