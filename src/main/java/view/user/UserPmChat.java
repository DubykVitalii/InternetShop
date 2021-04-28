package main.java.view.user;

import main.java.Session;
import main.java.dao.inmemorydb.PmChatInMemoryDao;
import main.java.view.Menu;

import java.util.Scanner;

public class UserPmChat implements Menu {
    private Scanner scannerInt;
    private Scanner scannerString;

    private final String[] itemsUserChat = {"1. Send a chat message", "2. Show chat", "0. Exit"};

    /**
     * User pm chat
     *
     * @param itemsUserChat - items pm chat user
     * @param choice        - choice user (1,2 or 0)
     *
     *                      <p>
     *                      if choice 1 send a chat new message
     *                      if choice 2 show all chat
     *                      if choice 0 exit main user menu
     */
    @Override
    public void show() {

        showItems(itemsUserChat);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);

        while (true) {
            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a text:");
                    String newMessage = scannerString.nextLine();
                    PmChatInMemoryDao.getEntity().addMessage(Session.getCurrentUser().getUsername(), newMessage);
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
        new UserMainMenu().show();
    }
}
