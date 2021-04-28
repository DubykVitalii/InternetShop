package main.java.view.user;

import main.java.ShoppingCart;
import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.service.OrderService;
import main.java.view.Menu;

import java.util.Scanner;

public class UserProductMenu implements Menu {
    private Scanner scanner;
    private final String[] itemsProductMenuUser = {"1. Product list", "2. Shopping Cart", "3. Shopping cart checkout", "0. Exit User Menu"};


    /**
     * Product menu user
     * <p>
     * @param itemsProductMenuUser - items product menu user
     * @param choice         - choice user (1 or 0)
     * if choice 1 show product list
     * if choice 2 show shopping cart
     * if choice 3 show shopping cart checkout
     * if choice 0 exit user main menu
     */
    @Override
    public void show() {
        showItems(itemsProductMenuUser);
        scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEntity(ProductInMemoryDao.getEntity().getAllProducts().toString());
                    System.out.println("1. Add shopping cart product");
                    System.out.println("0. Exit Product Menu");
                    int choiceBuyOrExit = scanner.nextInt();
                    if (choiceBuyOrExit == 1) {
                        System.out.println("Enter ID Product but");
                        int choice3 = scanner.nextInt();
                        OrderService.getOrderService().addProductToShoppingCart(ProductInMemoryDao.getEntity().getProductById(choice3));
                        show();
                    } else if (choiceBuyOrExit == 0) {
                        show();
                    } else {
                        System.err.println("Incorrect choice");
                        show();
                    }
                    break;
                case 2:
                    try {
                        showEntity(ShoppingCart.getShoppingCart().toString());
                        System.out.println("1. Remove product of shopping cart");
                        System.out.println("0. Exit product menu");
                        int removeProduct = scanner.nextInt();
                        if (removeProduct == 1) {
                            System.out.println("Please enter id product:");
                            int idProduct = scanner.nextInt();
                            OrderService.getOrderService().removeProductOfShoppingCart(ProductInMemoryDao.getEntity().getProductById(idProduct));
                            System.out.println("Product delete successfully");
                            if (ShoppingCart.getShoppingCart().getListOfProducts().isEmpty()) {
                                ShoppingCart.deleteShoppingCart();
                            }
                            show();
                        } else {
                            show();
                        }
                    } catch (NullPointerException e) {
                        System.err.println("Shopping cart is empty");
                        show();
                    }
                    break;
                case 3:

                    try {
                        showEntity(ShoppingCart.getShoppingCart().toString());
                        System.out.println("You confirm the shopping cart?");
                    } catch (NullPointerException e) {
                        System.err.println("Shopping cart is empty");
                        show();
                    }
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    int choice4 = scanner.nextInt();
                    if (choice4 == 1) {
                        OrderService.getOrderService().orderCheckout();
                        show();
                    } else {
                        show();
                    }
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.err.println("Incorrect choice");
                    show();
            }
        }
    }

    /**
     * Exit user menu
     */
    @Override
    public void exit() {
        new UserMainMenu().show();
    }
}
