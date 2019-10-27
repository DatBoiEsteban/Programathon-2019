package com.stardust.programathon2019.Model;

public class AttendanceRequest {
    private String date;
    private int formId;
    private int studentId;
    private int applicatorId;
    private String status;

    public AttendanceRequest(String date, int formId, int studentId, int applicatorId, String status) {
        this.date = date;
        this.formId = formId;
        this.studentId = studentId;
        this.applicatorId = applicatorId;
        this.status = status;
    }

    public AttendanceRequest() {

    }
}
