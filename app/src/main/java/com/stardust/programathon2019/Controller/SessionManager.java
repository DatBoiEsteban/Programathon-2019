package com.stardust.programathon2019.Controller;

import com.stardust.programathon2019.Model.Kid;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static  SessionManager instance = new SessionManager();
    private Session session;

    private SessionManager() {
        session = new Session();
    }


    public static SessionManager getInstance()
    {
        if (instance == null)
            instance = new SessionManager();

        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void endSession(){
        session = new Session();
    }
}
