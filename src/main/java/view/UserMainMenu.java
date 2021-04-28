package main.java.view;

public class UserMainMenu implements Menu {
    @Override
    public void show() {
        System.out.println("AHhaaa!!");
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
