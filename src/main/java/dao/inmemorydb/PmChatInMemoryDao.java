package main.java.dao.inmemorydb;


import main.java.dao.PmChatDao;
import main.java.model.Order;
import main.java.model.PmChat;

import java.util.*;

public class PmChatInMemoryDao implements PmChatDao {

    private final List<PmChat> pmChats = new ArrayList<>();
    private static PmChatDao entity;

    private PmChatInMemoryDao() {
    }

    public static PmChatDao getEntity() {
        if (entity == null) {
            entity = new PmChatInMemoryDao();
        }
        return entity;
    }


    @Override
    public void addMessage(String username, String message) {
        pmChats.add(new PmChat(username,message));
    }

    @Override
    public PmChat getChatById(int idChat) {
        PmChat pmChat = null;
        for (PmChat findChat : pmChats) {
            if (findChat.getIdChat() == (idChat)) {
                pmChat = findChat;
            }
        }
        return pmChat;
    }

    @Override
    public List<PmChat> getAllChat() {
        return List.copyOf(pmChats);
    }

}
