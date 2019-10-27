package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullForm {
    int id;
    String name;
    String instructions;
    String status;
    int minAgeMonths;
    int maxAgeMonths;
    int minAgeDays;
    int maxAgeDays;

    public FullForm() {
    }

    public FullForm(int id, String name, String instructions, String status, int minAgeMonths, int maxAgeMonths, int minAgeDays, int maxAgeDays) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.status = status;
        this.minAgeMonths = minAgeMonths;
        this.maxAgeMonths = maxAgeMonths;
        this.minAgeDays = minAgeDays;
        this.maxAgeDays = maxAgeDays;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstructins() {
        return instructions;
    }

    public String getStatus() {
        return status;
    }

    public int getMinAgeMonths() {
        return minAgeMonths;
    }

    public int getMaxAgeMonths() {
        return maxAgeMonths;
    }

    public int getMinAgeDays() {
        return minAgeDays;
    }

    public int getMaxAgeDays() {
        return maxAgeDays;
    }
}
