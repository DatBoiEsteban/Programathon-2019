package com.stardust.programathon2019.Controller;

import com.stardust.programathon2019.Model.Kid;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static  SessionManager instance = new SessionManager();
    private Session session;

    String key;
    Kid value;
    static Map<String, Kid> rawMap;

    private SessionManager() {
        session = new Session();
    }


    public static SessionManager getInstance()
    {
        if (instance == null) {
            instance = new SessionManager();
            rawMap = new HashMap<>();
        }

        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void endSession(){
        session = new Session();
    }

    public Map getRawMap() {
        return rawMap;
    }

    public void setRawMap(Map rawMap) {
        this.rawMap = rawMap;
    }
}
