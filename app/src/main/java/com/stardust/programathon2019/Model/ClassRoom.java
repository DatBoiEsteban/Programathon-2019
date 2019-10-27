package com.stardust.programathon2019.Model;

public class ClassRoom {
    int id;
    int classYear;
    String section;
    int status;
    int gradeId;
    int theacherId;

    public ClassRoom(int id, int classYear, String section, int status, int gradeId, int theacherId) {
        this.id = id;
        this.classYear = classYear;
        this.section = section;
        this.status = status;
        this.gradeId = gradeId;
        this.theacherId = theacherId;
    }
}
