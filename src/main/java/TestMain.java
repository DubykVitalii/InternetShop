package main.java;

import main.java.dao.ProductDao;
import main.java.dao.UserDao;
import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.Product;
import main.java.model.ProductCategory;
import main.java.model.User;

import java.util.UUID;

public class TestMain {
    public static void main(String[] args) {
//        ProductDao productDao = ProductInMemoryDao.getEntity();
//        Product product1 = new Product("cheese", 200, 1, ProductCategory.FOOD);
//        Product product2 = new Product("cheese", 200, 1, ProductCategory.FOOD);
//        productDao.addProduct(product1);
//        productDao.addProduct(product2);
//        productDao.getProductById(product1.getId());
//        productDao.getProductsByName(product2.getName());
//        productDao.getProductsByCategory(ProductCategory.FOOD);
//        productDao.removeProduct(product2.getId());
//        product2.setPrice(300);
//        productDao.addProduct(product2);
//        productDao.updateProduct(product2);

        // ============= User test
//        UserDao users = UserInMemoryDao.getEntity();
//        User user1 = new User("Sasha", "123");
//        User user2 = new User("Max", "321");
//
//        users.saveUser(user1);
//        users.saveUser(user2);
//        String user1Id = user1.getUserId();
//        String user2Id = user2.getUserId();
//        System.out.println(users.getUserById(user1Id));
//        System.out.println(users.getUserById(user2Id));
//        users.removeUser(user1Id);
//        System.out.println(users.getUserById(user1Id));
//        System.out.println(users.getUserById(user2Id));
//        System.out.println(users.getUserByUsername("Sasha"));
//        System.out.println(users.getUserByUsername("Max"));
        // ============= end User test
    }
}
