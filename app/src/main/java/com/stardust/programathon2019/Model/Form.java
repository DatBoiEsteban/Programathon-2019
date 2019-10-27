package com.stardust.programathon2019.Model;

public class Form {
    int id;
    String name;
    boolean applied;

    public Form(int id, String name, boolean applied) {
        this.id = id;
        this.name = name;
        this.applied = applied;
    }

    public String getName() {
        return name;
    }
}
