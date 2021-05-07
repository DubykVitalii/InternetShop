package main.java.view.user;

import main.java.ShoppingCart;
import main.java.model.ProductCategory;
import main.java.service.OrderService;
import main.java.service.ProductService;
import main.java.view.Menu;

import java.util.Scanner;

public class UserProductMenu implements Menu {
    private Scanner scannerString;
    private Scanner scannerInt;
    private final String[] itemsProductMenuUser = {"1. Product list", "2. Search by product categories", "3. Shopping Cart", "4. Shopping Cart checkout", "0. Exit User Menu"};


    /**
     * Product menu user
     * <p>
     *
     * itemsProductMenuUser - items product menu user
     * choice               - choice user (1 or 0)
     *                             if choice 1 show product list
     *                             if choice 2 search by product categories
     *                             if choice 3 show shopping cart
     *                             if choice 4 show shopping cart checkout
     *                             if choice 0 exit user main menu
     */
    @Override
    public void show() {
        showItems(itemsProductMenuUser);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);
        while (true) {
            int choice = scannerInt.nextInt();
            switch (choice) {
                case 1:
                    showEntity(ProductService.getInstance().getAllProducts().toString());
                    System.out.println("1. Add shopping cart product");
                    System.out.println("0. Exit Product Menu");
                    int choiceBuyOrExit = scannerInt.nextInt();
                    if (choiceBuyOrExit == 1) {
                        System.out.println("Enter ID Product but");
                        int choice3 = scannerInt.nextInt();
                        if (ProductService.getInstance().getProductById(choice3) != null) {
                            OrderService.getInstance().addProductToShoppingCart(ProductService.getInstance().getProductById(choice3));
                            System.out.println("Product successfully add to shopping cart...");
                            show();
                        } else {
                            System.err.println("The product with such ID does not exist");
                            show();
                        }
                    } else if (choiceBuyOrExit == 0) {
                        show();
                    } else {
                        System.err.println("Incorrect choice...");
                        show();
                    }
                    break;
                case 2:
                    for (int i = 0; i < ProductCategory.values().length; i++) {
                        System.out.println("ID:" + i + " " + ProductCategory.values()[i]);
                    }
                    System.out.println("Enter a category id product:");
                    int categoryId = scannerInt.nextInt();
                    if (categoryId <= ProductCategory.values().length) {
                        try {
                            System.out.println(ProductService.getInstance().getProductsByCategory(ProductCategory.values()[categoryId]).toString());
                        } catch (NullPointerException e) {
                            System.err.println("Category is empty");
                            show();
                        }
                        System.out.println("1. Add shopping cart product");
                        System.out.println("0. Exit Product Menu");
                        int choiceBuyCategoryOrExit = scannerInt.nextInt();
                        if (choiceBuyCategoryOrExit == 1) {
                            System.out.println("Enter ID Product but");
                            int choice3 = scannerInt.nextInt();
                            OrderService.getInstance().addProductToShoppingCart(ProductService.getInstance().getProductById(choice3));
                            show();
                        } else if (choiceBuyCategoryOrExit == 0) {
                            show();
                        } else {
                            System.err.println("Incorrect choice...");
                            show();
                        }
                    } else {
                        System.err.println("Incorrect choice...");
                        show();
                    }
                    break;
                case 3:
                    try {
                        showEntity(ShoppingCart.getShoppingCart().toString());
                        System.out.println("1. Remove product of shopping cart");
                        System.out.println("0. Exit product menu");
                        int removeProduct = scannerInt.nextInt();
                        if (removeProduct == 1) {
                            System.out.println("Please enter id product:");
                            int idProduct = scannerInt.nextInt();
                            OrderService.getInstance().removeProductOfShoppingCart(ProductService.getInstance().getProductById(idProduct));
                            System.out.println("Product delete successfully...");
                            if (ShoppingCart.getShoppingCart().getListOfProducts().isEmpty()) {
                                ShoppingCart.deleteShoppingCart();
                            }
                            show();
                        } else {
                            show();
                        }
                    } catch (NullPointerException e) {
                        System.err.println("Shopping cart is empty...");
                        show();
                    }
                    break;
                case 4:
                    try {
                        showEntity(ShoppingCart.getShoppingCart().toString());
                        System.out.println("You confirm the shopping cart?");
                    } catch (NullPointerException e) {
                        System.err.println("Shopping cart is empty...");
                        show();
                    }
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    int choice4 = scannerInt.nextInt();
                    if (choice4 == 1) {
                        OrderService.getInstance().orderCheckout();
                        show();
                    } else {
                        show();
                    }
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.err.println("Incorrect choice...");
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
