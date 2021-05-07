package main.java.view.admin;

import main.java.model.Product;
import main.java.model.ProductCategory;
import main.java.service.ProductService;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminProductMenu implements Menu {
    private Scanner scannerInt;
    private Scanner scannerString;

    private final String[] itemsProductMenuAdmin = {"1. Edit existing product details", "2. Add new product", "3. List of all product.", "4. Remove product", "0. Exit Admin Menu"};

    /**
     * Admin product menu
     *
     * itemsProductMenuAdmin - items product menu admin
     * choice                - choice user (1,2,3 or 0)
     *                              <p>
     *                              if choice 1 show product and edit product
     *                              if choice 2 add new product
     *                              if choice 3 show list all product
     *                              if choice 4 remove product menu
     *                              if choice 0 exit admin main menu
     */
    @Override
    public void show() {
        showItems(itemsProductMenuAdmin);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);
        while (true) {
            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    showEntity(ProductService.getInstance().getAllProducts().toString());
                    System.out.println("Enter ID product:");
                    int idProduct = scannerInt.nextInt();
                    System.out.println("Select details to edit");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    int editDetails = scannerInt.nextInt();
                    if (editDetails == 1) {
                        System.out.println("Enter a new name product");
                        String nameProduct = scannerString.next();
                        ProductService.getInstance().getProductById(idProduct).setName(nameProduct);
                        show();
                    } else if (editDetails == 2) {
                        System.out.println("Enter a new price product");
                        double price = scannerInt.nextDouble();
                        ProductService.getInstance().getProductById(idProduct).setPrice(price);
                        show();
                    } else {
                        System.err.println("Incorrect choice...");
                        show();
                    }
                    break;
                case 2:
                    System.out.println("Enter a name product:");
                    String nameProduct = scannerString.next();
                    System.out.println("Enter a price product:");
                    double price = scannerInt.nextDouble();
                    System.out.println("Enter a category id product:");
                    for (int i = 0; i < ProductCategory.values().length; i++) {
                        System.out.println("ID:" + i + " " + ProductCategory.values()[i]);
                    }
                    int categoryId = scannerInt.nextInt();
                    try {
                        ProductService.getInstance().addProduct(new Product(nameProduct, price, ProductCategory.values()[categoryId]));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("There is no product category...");
                        show();
                    }
                    System.out.println("Product successfully added...");
                    show();
                    break;
                case 3:
                    showEntity(ProductService.getInstance().getAllProducts().toString());
                    show();
                case 4:
                    showEntity(ProductService.getInstance().getAllProducts().toString());
                    System.out.println("Enter ID product remove:");
                    int idProductRemove = scannerInt.nextInt();

                    if (ProductService.getInstance().getProductById(idProductRemove) != null) {
                        ProductService.getInstance().removeProduct(idProductRemove);
                        System.out.println("Product successfully remove...");
                    } else {
                        System.err.println("The product with such ID does not exist...");
                        show();
                    }
                    show();
                case 0:
                    exit();
                    break;
                default:
                    System.err.println("Incorrect choice");
                    show();
            }
        }
    }

    @Override
    public void exit() {
        new AdminMainMenu().show();
    }
}
