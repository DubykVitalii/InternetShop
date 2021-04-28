package main.java.service;

public class PmChatService {
    private static PmChatService pmChatService;

    private PmChatService() {
    }

    public static PmChatService getPmChatService() {
        if (pmChatService == null) {
            pmChatService = new PmChatService();
        }
        return pmChatService;
    }

}
