package com.stardust.programathon2019.Model;

public class ResultASQ {
    int index;
    int value;
    int id;


    public ResultASQ(int index) {
        this.index = index;
        id =0;
    }

    public ResultASQ() {
        id =0;
    }

    public ResultASQ(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
