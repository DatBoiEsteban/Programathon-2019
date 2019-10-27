package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private int id;
    private int index;
    private int value;

    public Result() {
    }

    public Result(int id, int index, int value) {
        this.id = id;
        this.index = index;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
