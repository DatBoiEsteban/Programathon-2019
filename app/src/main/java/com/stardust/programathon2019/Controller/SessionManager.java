package com.stardust.programathon2019.Controller;

class SessionManager {
    private static final SessionManager instance = new SessionManager();
    private Session session;

    static SessionManager getInstance() {
        return instance;
    }

    private SessionManager() {
    }

    public void createSesion(String User, String password) {
        session = new Session();
        session.login(User,password);
    }
}
