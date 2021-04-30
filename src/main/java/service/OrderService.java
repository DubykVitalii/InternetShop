package main.java.service;

import main.java.Session;
import main.java.ShoppingCart;
import main.java.dao.inmemorydb.OrderInMemoryDao;
import main.java.model.Order;
import main.java.model.OrderStatus;
import main.java.model.Product;

import java.util.List;

public class OrderService {

    private static OrderService orderService;

    private OrderService() {
    }

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    /**
     * Add product to shopping cart
     * <p>
     * If the shopping cart is empty, then new shopping cart is created and product is added to shopping cart.
     * If the shopping cart is not empty, then product is added to shopping cart.
     */
    public void addProductToShoppingCart(Product product) {
        if (ShoppingCart.getShoppingCart() == null) {
            ShoppingCart.createShoppingCart();
        }
        ShoppingCart.getShoppingCart().addProductOfOrder(product);
    }

    /**
     * Remove product of shopping cart
     */
    public void removeProductOfShoppingCart(Product product) {
        ShoppingCart.getShoppingCart().removeProductOfOrder(product);

    }

    /**
     * Order checkout
     * <p>
     * Order confirm as User.
     * Shopping cart added DB (OrderInMemoryDao) and delete shopping cart.
     */
    public void orderCheckout() {
        OrderInMemoryDao.getEntity().addOrderInMemoryDao(ShoppingCart.getShoppingCart());
        ShoppingCart.deleteShoppingCart();
    }

    /**
     * Orders user
     * <p>
     * Show orders user.
     */

    public String ordersUser() {
        return OrderInMemoryDao.getEntity().getUserOrders(Session.getCurrentUser().getUserId()).toString();
    }

    /**
     * Cancel order as user
     * <p>
     * Change order status = CANCELLED_USER
     */
    public void cancelOrderAsUser(Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED_USER);
    }

    /**
     * Cancel order as admin
     * <p>
     * Change order status = CANCELLED
     */

    public void orderCancelledAsAdmin(Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED);
    }

    /**
     * Confirm order as admin
     * <p>
     * Change order status = CONFIRMED
     */
    public void orderConfirmed(Order order) {
        order.setOrderStatus(OrderStatus.CONFIRMED);
    }

    /**
     * Delete order as admin
     * <p>
     *
     * @param orderId id order
     *                Delete order(orderId) from db.
     */
    public void deleteOrder(int orderId) {
        OrderInMemoryDao.getEntity().deleteOrder(OrderInMemoryDao.getEntity().getOrderById(orderId));
    }

    /**
     * Get all orders
     *
     * @return List<Order> all orders
     */
    public List<Order> getAllOrders() {
        return List.copyOf(OrderInMemoryDao.getEntity().getAllOrders());
    }

    /**
     * Get order by id
     *
     * @param orderId - id order
     * @return find order by id
     */
    public Order getOrderById(int orderId) {
        return OrderInMemoryDao.getEntity().getOrderById(orderId);
    }
}

