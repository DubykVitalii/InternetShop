package main.java.dao;

import main.java.model.Order;

import java.util.List;

public interface OrderDao {

    void addOrderInMemoryDao(Order order);

    void deleteOrder(Order order);

    Order getOrderById(int orderId);

    List<Order> getAllOrders();

    List<Order> getUserOrders(int userId);

}
