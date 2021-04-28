package main.java.view.admin;

import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.model.Product;
import main.java.model.ProductCategory;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminProductMenu implements Menu {
    private Scanner scanner;
    private final String[] itemsProductMenuAdmin = {"1. Edit existing product details", "2. Add new product", "3. List of all product.", "0. Exit Admin Menu"};

    /**
     * Admin product menu
     *
     * @param itemsProductMenuAdmin - items product menu admin
     * @param choice                - choice user (1,2,3 or 0)
     *                              <p>
     *                              if choice 1 show product and edit product
     *                              if choice 2 add new product
     *                              if choice 3 show list all product
     *                              if choice 0 exit admin main menu
     */
    @Override
    public void show() {
        showItems(itemsProductMenuAdmin);
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEntity(ProductInMemoryDao.getEntity().getAllProducts().toString());
                    System.out.println("Enter ID product:");
                    int idProduct = scanner.nextInt();
                    System.out.println("Select details to edit");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("3. Amount in stock");
                    int editDetails = scanner.nextInt();
                    if (editDetails == 1) {
                        System.out.println("Enter a new name product");
                        String nameProduct = scanner.next();
                        ProductInMemoryDao.getEntity().getProductById(idProduct).setName(nameProduct);
                        show();
                    } else if (editDetails == 2) {
                        System.out.println("Enter a new price product");
                        double price = scanner.nextDouble();
                        ProductInMemoryDao.getEntity().getProductById(idProduct).setPrice(price);
                        show();
                    } else if (editDetails == 3) {
                        System.out.println("Enter a new amount in stock product");
                        int amountInStock = scanner.nextInt();
                        ProductInMemoryDao.getEntity().getProductById(idProduct).setAmountInStock(amountInStock);
                        show();
                    } else {
                        System.err.println("Incorrect choice...");
                        show();
                    }
                    break;
                case 2:
                    System.out.println("Enter a name product:");
                    String nameProduct = scanner.next();
                    System.out.println("Enter a price product:");
                    double price = scanner.nextDouble();
                    System.out.println("Enter an amount in stock product:");
                    int amountInStock = scanner.nextInt();
                    System.out.println("Enter a category id product:");
                    for (int i = 0; i < ProductCategory.values().length; i++) {
                        System.out.println("ID:" + i + " " + ProductCategory.values()[i]);
                    }
                    int categoryId = scanner.nextInt();
                    ProductInMemoryDao.getEntity().addProduct(new Product(nameProduct, price, amountInStock, ProductCategory.values()[categoryId]));
                    System.out.println("Product successfully added...");
                    show();
                    break;
                case 3:
                    showEntity(ProductInMemoryDao.getEntity().getAllProducts().toString());
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
