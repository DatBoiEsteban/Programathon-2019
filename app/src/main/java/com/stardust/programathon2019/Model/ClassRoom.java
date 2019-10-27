package com.stardust.programathon2019.Model;

public class ClassRoom {
    int id;
    double classYear;
    String section;
    int status;
    int gradeId;
    int theacherId;

    public ClassRoom(int id, double classYear, String section, int status, int gradeId, int theacherId) {
        this.id = id;
        this.classYear = classYear;
        this.section = section;
        this.status = status;
        this.gradeId = gradeId;
        this.theacherId = theacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getClassYear() {
        return classYear;
    }

    public void setClassYear(double classYear) {
        this.classYear = classYear;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getTheacherId() {
        return theacherId;
    }

    public void setTheacherId(int theacherId) {
        this.theacherId = theacherId;
    }
}
