package main.java.dao;

import main.java.model.PmChat;

import java.util.List;

public interface PmChatDao {

    void addMessage(String username, String message);

    PmChat getChatById(int idChat);

    List<PmChat> getAllChat();
}
