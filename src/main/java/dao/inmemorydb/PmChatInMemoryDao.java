package main.java.dao.inmemorydb;


import main.java.dao.PmChatDao;
import main.java.model.PmChat;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Add new message
     *
     * @param message
     */

    @Override
    public void addMessage(String username, String message) {
        pmChats.add(new PmChat(username, message));
    }

    /**
     * Get chat by id
     *
     * @return chat by id
     */

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

    /**
     * Get all chat
     *
     * @return all chat
     */
    @Override
    public List<PmChat> getAllChat() {
        return List.copyOf(pmChats);
    }

}
