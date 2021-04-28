package main.java.view.admin;

import main.java.Session;
import main.java.dao.inmemorydb.PmChatInMemoryDao;
import main.java.view.Menu;

import java.util.Scanner;

public class AdminPmChat implements Menu {
    private Scanner scannerInt;
    private Scanner scannerString;

    private final String[] itemsAdminChat = {"1.Send a chat message","2.Show chat" , "0. Exit"};

    @Override
    public void show() {

        showItems(itemsAdminChat);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);
        while (true) {
            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a text:");
                    String newMessage = scannerString.nextLine();
                    PmChatInMemoryDao.getEntity().addMessage(Session.getCurrentUser().getUsername(),newMessage);
                    System.out.println("Message send successfully");
                    show();
                    break;
                case 2:
                    System.out.print("Chat:");
                    showEntity(PmChatInMemoryDao.getEntity().getAllChat().toString());
                    System.out.println();
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
