//Future scope (Prototype code for Session management)

package com.hsbc.bugreportapp.services;

import java.util.Timer;
import java.util.TimerTask;

import com.hsbc.bugreportapp.beans.SessionManager;

public class SessionManagementImpl implements SessionManagementService {
	
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000; // 30 minutes in milliseconds

    public static void startSessionTimeoutTask(String sessionId) {
        Timer timer = new Timer(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Remove the user session when the timer runs
                SessionManager.getInstance().removeUser(sessionId);
                System.out.println("Session timeout for session ID: " + sessionId);
            }
        }, SESSION_TIMEOUT);
    }
}

