package com.stardust.programathon2019.Controller;

import com.stardust.programathon2019.Network.SessionService;

public class Session {
    private boolean logged;
    private SessionService session;

    public Session() {
    }

    public boolean isLoggedIn() {
        return logged;
    }

    public void login(String user, String pass) {
        session = ServiceGenerator.createService(SessionService.class, user, pass);
    }

    public <S> S createService(Class classToInstantiate){
        return null;
    }
}
