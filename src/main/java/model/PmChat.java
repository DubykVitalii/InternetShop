package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class PmChat {
    private static int count = 0;
    private int idChat;
    private String username;
    private List<String> message = new ArrayList<>();

    public PmChat(String username, String message) {
        this.idChat = count++;
        this.username = username;
        this.message.add(username+": "+message);
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(String username, String message) {
        this.message.add(username+": "+message);
    }

    @Override
    public String toString() {
        return "\n" + message;
    }
}
