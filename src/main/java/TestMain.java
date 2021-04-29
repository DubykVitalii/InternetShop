package main.java;

import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.model.ProductCategory;
import main.java.view.LoginMenu;
import main.java.view.Menu;

public class TestMain {
    public static void main(String[] args) {
        Menu menu = new LoginMenu();
        menu.show();


    }
}
