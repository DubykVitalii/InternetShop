package main.java.dao;

import main.java.model.PmChat;

import java.util.List;
import java.util.Map;

public interface PmChatDao {

    void addMessageUser(String username, String message);

    void addMessageAdmin(String adminname,String username, String message);

    List<PmChat> getChatUser(String username);

    Map<String, List<PmChat>> getAllChat();

    public void userChatsName();

}
