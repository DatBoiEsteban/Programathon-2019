package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Kid {
    String dob;
    String joinDate;
    int earlyBirthAmount;
    int sponsorId;
    ClassRoom classRoom;
    Form form;
    int id;
    int dni;
    String firstName;
    String lastName;
    String gender;
    int locationId;
    String status;


    @JsonProperty("form")
    private void unpackForm(Map<String,Object> form) {
        int id = (Integer)form.get("id");
        String name = (String)form.get("name");
        boolean applied = (Boolean)form.get("applied");
        this.form = new Form(id, name, applied);

    }

    @JsonProperty("classRoom")
    private void unpackClassRoom(Map<String,Object> classRoom) {
        int id = (Integer)classRoom.get("id");
        double classYear = (Double)classRoom.get("classYear");
        String section = (String)classRoom.get("section");
        int status = (Integer)classRoom.get("status");
        int gradeId = (Integer)classRoom.get("gradeId");
        int teacherId = (Integer)classRoom.get("teacherId");

        this.classRoom = new ClassRoom(id,classYear,section,status,gradeId,teacherId);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public int getEarlyBirthAmount() {
        return earlyBirthAmount;
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Form getForm() {
        return form;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getGender() {
        return gender;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getStatus() {
        return status;
    }
}
