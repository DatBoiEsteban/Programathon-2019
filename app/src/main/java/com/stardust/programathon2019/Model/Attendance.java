package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Attendance {
    private int id;
    private String date;
    private int formId;
    private int studentId;
    private int applicatorId;
    private String status;
    private AttendanceForm form;


    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getFormId() {
        return formId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getApplicatorId() {
        return applicatorId;
    }

    public String getStatus() {
        return status;
    }

    public AttendanceForm getForm() {
        return form;
    }

    @JsonProperty("form")
    private void unpackForm(Map<String,Object> form) {
        if(form == null)return;

        int id = (Integer)form.get("id");
        String name = (String)form.get("name");
        this.form = new AttendanceForm(id, name);

    }
}
