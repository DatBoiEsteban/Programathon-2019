package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendanceResult {

    int attendanceId;
    List<AreaResultASQ> resultList;

    public AttendanceResult() {
    }

    public AttendanceResult(int attendanceId, List<AreaResultASQ> resultList) {
        this.attendanceId = attendanceId;
        this.resultList = resultList;
    }

    public List<AreaResultASQ> getResultList() {
        return resultList;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setResultList(List<AreaResultASQ> resultList) {
        this.resultList = resultList;
    }
}
