package main.java;

import main.java.view.LoginMenu;
import main.java.view.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new LoginMenu();
        menu.show();
    }
}