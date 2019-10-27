package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendanceResult {

    int attendanceId;
    List<AreaResult> resultList;

    public List<AreaResult> getResultList() {
        return resultList;
    }
}
