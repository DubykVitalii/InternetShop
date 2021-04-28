package main.java.dao.inmemorydb;


import main.java.dao.PmChatDao;
import main.java.model.PmChat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PmChatInMemoryDao implements PmChatDao {

    private final Map<String, List<PmChat>> pmChats = new TreeMap<>();
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
     * Add new message user
     *
     * @param message
     */

    @Override
    public void addMessageUser(String username, String message) {
        if (pmChats.get(username) == null) {
            List<PmChat> pchat = new ArrayList<>();
            pchat.add(new PmChat(username, message));
            pmChats.put(username, pchat);
        } else {

            PmChat pmChat = new PmChat(username, message);
            pmChats.get(username).add(pmChat);
        }
    }

    /**
     * Add new message admin
     *
     * @param message
     */
    @Override
    public void addMessageAdmin(String adminname, String username, String message) {
        PmChat pmChat = new PmChat(adminname, message);
        pmChats.get(username).add(pmChat);
    }

    /**
     * Get all user
     *
     * @return all chat
     */
    @Override
    public List<PmChat> getChatUser(String username) {

        return pmChats.get(username);
    }

    /**
     * Get all chat
     *
     * @return all chat
     */

    @Override
    public Map<String, List<PmChat>> getAllChat() {
        return pmChats;
    }

    /**
     * Get chats name
     * <p>
     * void chat name(username is chat name)
     */
    public void userChatsName() {
        for (Map.Entry<String, List<PmChat>> pmChat : pmChats.entrySet()) {
            System.out.println(pmChat.getKey());
        }
    }

}
