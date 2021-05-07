package main.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static int count = 0;
    private final int orderId;
    private final Date dateCreated;
    private final int customerId;
    private List<Product> listOfProducts = new ArrayList<>();
    private double sum;
    private OrderStatus orderStatus;

    public Order(int customerId) {
        this.orderId = count++;
        this.dateCreated = new Date();
        this.customerId = customerId;
        this.sum = 0;
        this.orderStatus = OrderStatus.UNCONFIRMED;
    }

    public Order(int customerId, Product product) {
        this.orderId = count++;
        this.dateCreated = new Date();
        this.customerId = customerId;
        this.listOfProducts.add(product);
        this.sum = product.getPrice();
        this.orderStatus = OrderStatus.UNCONFIRMED;
    }

    /**
     * Get order by id
     *
     * @return found order by id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Get customer id order
     *
     * @return found id customer order
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Get list of product
     *
     * @return list of product order
     */
    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    /**
     * Set order status
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Add product of order
     */
    public void addProductOfOrder(Product product) {
        this.listOfProducts.add(product);
        this.sum = sum + product.getPrice();
    }

    /**
     * Remove product of order
     */
    public void removeProductOfOrder(Product product) {
        this.listOfProducts.remove(product);
        this.sum = this.sum - product.getPrice();
    }


    @Override
    public String toString() {
        return "\nOrder ID:" + orderId +
                ",\nDate:" + dateCreated +
                ",\nList of product:" + listOfProducts +
                ",\nSum order:" + sum +
                ",\nOrder Status:" + orderStatus +
                '}';
    }
}
