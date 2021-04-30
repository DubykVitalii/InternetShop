package main.java.view.admin;

import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.service.AdminService;
import main.java.service.UserService;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminUserMenu implements Menu {
    private Scanner scanner;

    private final String[] itemsUserMenuAdmin = {"1. Block/Unlock users", "0. Exit Admin Menu"};

    /**
     * Admin user menu
     *
     * @param itemsUserMenuAdmin - items user menu admin
     * @param choice             - choice user (1,2,3 or 0)
     *                           <p>
     *                           if choice 1 show users list and block/unlock users
     *                           if choice 0 exit admin main menu
     */
    @Override
    public void show() {
        showItems(itemsUserMenuAdmin);
        scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEntity(UserService.getInstance().getAllUsers().toString());
                    System.out.println("Enter ID user");
                    int choiceIdUser = scanner.nextInt();
                    System.out.println("1. Blocked user");
                    System.out.println("2. Unlocked user");
                    int choiceBlockOrUnlockUser = scanner.nextInt();
                    if (choiceBlockOrUnlockUser == 1) {
                        AdminService.getInstance().blockUser(UserService.getInstance().getUserById(choiceIdUser));
                        show();
                    } else if (choiceBlockOrUnlockUser == 2) {
                        AdminService.getInstance().unBlockUser(UserService.getInstance().getUserById(choiceIdUser));
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
