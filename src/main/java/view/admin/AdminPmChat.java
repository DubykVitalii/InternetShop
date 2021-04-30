package main.java.view.admin;

import main.java.Session;
import main.java.dao.inmemorydb.PmChatInMemoryDao;
import main.java.service.PmChatService;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminPmChat implements Menu {
    private Scanner scannerInt;
    private Scanner scannerString;

    private final String[] itemsAdminChat = {"1.Show chat", "0. Exit"};

    /**
     * Admin pm chat
     *
     * @param itemsAdminChat - items pm chat admin
     * @param choice         - choice user (1 or 0)
     *
     *                       <p>
     *                       if choice 1 show chats with users
     *                       if choice 0 exit main admin menu
     */
    @Override
    public void show() {
        showItems(itemsAdminChat);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);
        while (true) {
            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Chats:");
                    try {
                        PmChatService.getInstance().userChatsName();
                    } catch (NullPointerException e) {
                        System.out.println("Chats is empty");
                        show();
                    }
                    System.out.println("Enter userChatsName:");
                    String userChatName = scannerString.nextLine();
                    try {
                        showEntity( PmChatService.getInstance().getChatUser(userChatName).toString());
                    } catch (NullPointerException e) {
                        System.err.println("Chat not found");
                        show();
                    }
                    System.out.println("Enter a text:");
                    String newMessage = scannerString.nextLine();
                    PmChatService.getInstance().addMessageAdmin(Session.getCurrentUser().getUsername(), userChatName, newMessage);
                    System.out.println("Message send successfully");
                    show();
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
