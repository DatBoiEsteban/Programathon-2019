package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ResultASQ {

    int value;
    int index;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResultASQ(int index) {
        this.index = index;
    }

    public ResultASQ() {

    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
