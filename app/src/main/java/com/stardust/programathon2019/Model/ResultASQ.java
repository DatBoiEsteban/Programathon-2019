package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ResultASQ {
    int index;
<<<<<<< HEAD
    int value;
    int id;


=======
    @JsonIgnoreProperties(ignoreUnknown = true)
>>>>>>> 9950558565d02af2a2221c73fc634b4f43243efd
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

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
