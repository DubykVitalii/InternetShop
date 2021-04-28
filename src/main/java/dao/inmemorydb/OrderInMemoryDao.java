package main.java.dao.inmemorydb;


import main.java.dao.OrderDao;
import main.java.model.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderInMemoryDao implements OrderDao {

    private final Set<Order> orders = new HashSet<>();
    private static OrderDao entity;

    private OrderInMemoryDao() {
    }

    public static OrderDao getEntity() {
        if (entity == null) {
            entity = new OrderInMemoryDao();
        }
        return entity;
    }

    /**
     * Add order in memory dao
     */

    @Override
    public void addOrderInMemoryDao(Order order) {
        orders.add(order);
    }

    /**
     * Delete order in memory dao
     */

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    /**
     * Get order by id
     *
     * @param orderId - id order
     * @return find order by id
     */

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        for (Order findOrder : orders) {
            if (findOrder.getOrderId() == (orderId)) {
                order = findOrder;
            }
        }
        return order;
    }

    /**
     * Get all orders
     *
     * @return List<Order> all orders
     */

    @Override
    public List<Order> getAllOrders() {
        return List.copyOf(orders);
    }

    /**
     * Get user orders
     *
     * @param userId - id user
     * @return List<Order> user orders
     */

    @Override
    public List<Order> getUserOrders(int userId) {
        List<Order> ordersUser;
        ordersUser = orders.stream().filter(order -> order.getCustomerId() == userId).collect(Collectors.toList());
        return ordersUser;
    }


}
