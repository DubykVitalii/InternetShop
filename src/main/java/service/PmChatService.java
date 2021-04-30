package main.java.service;

import main.java.dao.PmChatDao;
import main.java.dao.inmemorydb.PmChatInMemoryDao;
import main.java.dao.inmemorydb.ProductInMemoryDao;
import main.java.model.PmChat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PmChatService {
    private static PmChatService pmChatService;

    private PmChatService() {
    }

    public static PmChatService getInstance() {
        if (pmChatService == null) {
            pmChatService = new PmChatService();
        }
        return pmChatService;
    }

    /**
     * Add new message user
     *
     * @param message
     */
    public void addMessageUser(String username, String message) {
        PmChatInMemoryDao.getEntity().addMessageUser(username, message);
    }

    /**
     * Add new message admin
     *
     * @param message
     */
    public void addMessageAdmin(String adminname, String username, String message) {
        PmChatInMemoryDao.getEntity().addMessageAdmin(adminname,username,message);
    }

    /**
     * Get all user
     *
     * @return all chat
     */
    public List<PmChat> getChatUser(String username) {

        return PmChatInMemoryDao.getEntity().getChatUser(username);
    }

    /**
     * Get all chat
     *
     * @return all chat
     */
    public Map<String, List<PmChat>> getAllChat() {

        return PmChatInMemoryDao.getEntity().getAllChat();
    }

    /**
     * Get chats name
     * <p>
     * void chat name(username is chat name)
     */
    public void userChatsName() {
       PmChatInMemoryDao.getEntity().userChatsName();
    }

}
