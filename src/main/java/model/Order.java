package main.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private final String orderId;
    private final Date dateCreated;
    private final String customerId;
    private List<Product> listOfProducts = new ArrayList<>();
    private double sum;
    private OrderStatus orderStatus;

    public Order(String customerId) {
        this.orderId = UUID.randomUUID().toString();
        this.dateCreated = new Date();
        this.customerId = customerId;
        this.sum = 0;
        this.orderStatus = OrderStatus.UNCONFIRMED;
    }

    public Order(String customerId, Product product) {
        this.orderId = UUID.randomUUID().toString();
        this.dateCreated = new Date();
        this.customerId = customerId;
        this.listOfProducts.add(product);
        this.sum = product.getPrice();
        this.orderStatus = OrderStatus.UNCONFIRMED;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public OrderStatus getDeliveryStatusOrder() {
        return orderStatus;
    }

    public void setDeliveryStatusOrder(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addProductOfOrder(Product product) {
        this.listOfProducts.add(product);
        this.sum = sum + product.getPrice();
        product.setAmountInStock(product.getAmountInStock() - 1);
    }

    public void removeProductOfOrder(Product product) {
        this.listOfProducts.remove(product);
        this.sum = this.sum - product.getPrice();
        product.setAmountInStock(product.getAmountInStock() + 1);
    }


    @Override
    public String toString() {
        return "\nOrder{" +
                ", date=" + dateCreated +
                ", customerId=" + customerId +
                ", listOfProduct=" + listOfProducts +
                ", sum=" + sum +
                ", deliveryStatusOrder=" + orderStatus +
                '}';
    }
}
