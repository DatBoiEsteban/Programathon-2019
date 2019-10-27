package com.stardust.programathon2019.Model;

public class AttendanceForm {
    private int id;
    private String name;
    private String instructions;
    private String status;
    private int minAgeMonths;
    private int minAgeDays;
    private int maxAgeMonths;
    private int maxAgeDays;

    public AttendanceForm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMinAgeMonths() {
        return minAgeMonths;
    }

    public void setMinAgeMonths(int minAgeMonths) {
        this.minAgeMonths = minAgeMonths;
    }

    public int getMinAgeDays() {
        return minAgeDays;
    }

    public void setMinAgeDays(int minAgeDays) {
        this.minAgeDays = minAgeDays;
    }

    public int getMaxAgeMonths() {
        return maxAgeMonths;
    }

    public void setMaxAgeMonths(int maxAgeMonths) {
        this.maxAgeMonths = maxAgeMonths;
    }

    public int getMaxAgeDays() {
        return maxAgeDays;
    }

    public void setMaxAgeDays(int maxAgeDays) {
        this.maxAgeDays = maxAgeDays;
    }
}
