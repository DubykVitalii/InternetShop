package main.java.view;

public interface Menu {

    void show();

    void exit();


    /**
     * Methods show entity (orders,product and users)
     */

    default void showEntity(String strings) {
        strings = strings.replaceAll("[^a-zA-Z0-9:.? \n]", "");
        System.out.println(strings);
    }


    /**
     * Methods show items
     */
    default void showItems(String[] items) {
        for (String item : items) {
            System.out.println(item);
        }
    }
}
