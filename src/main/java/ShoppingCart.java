package main.java;

import main.java.model.Order;

public class ShoppingCart {

    private static Order shoppingCart = null;

    public static Order getShoppingCart() {
        return shoppingCart;
    }

    public static void createShoppingCart() {
        shoppingCart = new Order(Session.getCurrentUser().getUserId());
    }

    public static void deleteShoppingCart() {
        shoppingCart = null;
    }
}
