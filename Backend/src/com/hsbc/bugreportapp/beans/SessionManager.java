// Future scope (Prototype code for Session management)


package com.hsbc.bugreportapp.beans;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static SessionManager instance;
    private Map<String, User> activeSessions;

    private SessionManager() {
        activeSessions = new HashMap<>();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getUser(String sessionId) {
        return activeSessions.get(sessionId);
    }

    public void addUser(String sessionId, User user) {
        activeSessions.put(sessionId, user);
    }

    public void removeUser(String sessionId) {
        activeSessions.remove(sessionId);
    }
}
