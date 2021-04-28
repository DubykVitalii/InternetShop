package main.java.view.admin;

import main.java.dao.inmemorydb.OrderInMemoryDao;
import main.java.service.OrderService;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminOrderMenu implements Menu {
    private Scanner scanner;

    private final String[] itemsOrderMenuAdmin = {"1. Confirm/unconfirmed order", "0 Exit Admin Menu"};

    /**
     * Admin order menu
     *
     * @param  itemsOrderMenuAdmin - items order menu admin
     * @param  choice        - choice user (1,2,3 or 0)
     * <p>
     * if choice 1 show orders user and confirm/unconfirmed order
     * if choice 0 exit admin main menu
     */

    @Override
    public void show() {
        showItems(itemsOrderMenuAdmin);
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEntity(OrderInMemoryDao.getEntity().getAllOrders().toString());
                    System.out.println("Enter ID product");
                    int choiceIdProduct = scanner.nextInt();
                    System.out.println("1. Confirm order");
                    System.out.println("2. Unconfirmed order");
                    int choiceConfirmOrUnconfirmed = scanner.nextInt();
                    if (choiceConfirmOrUnconfirmed == 1) {
                        OrderService.getOrderService().orderConfirmed(OrderInMemoryDao.getEntity().getOrderById(choiceIdProduct));
                        show();
                    } else if (choiceConfirmOrUnconfirmed == 2) {
                        OrderService.getOrderService().orderCancelledAsAdmin(OrderInMemoryDao.getEntity().getOrderById(choiceIdProduct));
                        show();
                    } else {
                        System.err.println("Incorrect choice");
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

    @Override
    public void exit() {
        new AdminMainMenu().show();
    }
}