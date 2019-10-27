package com.stardust.programathon2019.Model;

import android.os.Build;
import android.widget.Switch;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
        if(form == null)return;

        int id = (Integer)form.get("id");
        String name = (String)form.get("name");
        boolean applied = (Boolean)form.get("applied");
        this.form = new Form(id, name, applied);

    }

    @JsonProperty("classRoom")
    private void unpackClassRoom(Map<String,Object> classRoom) {
        if(classRoom == null)return;

        int id = (Integer)classRoom.get("id");
        double classYear = (Double)classRoom.get("classYear");
        String section = (String)classRoom.get("section");
        int status = (Integer)classRoom.get("status");
        int gradeId = (Integer)classRoom.get("gradeId");
        int teacherId = (Integer)classRoom.get("teacherId");

        this.classRoom = new ClassRoom(id,classYear,section,status,gradeId,teacherId);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getAsq3Test(Date compareDate){
        DateFormat m_ISO8601Local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String result = "";
        try {
            System.out.println(dob);

            Date dateOfBirth= m_ISO8601Local.parse(dob);
            Date today = compareDate;

            LocalDate ldateOfBirth = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ltoday = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long months =  ChronoUnit.MONTHS.between(ldateOfBirth,ltoday);
            long days =  ChronoUnit.DAYS.between(ldateOfBirth.plusMonths(months),ltoday);
            System.out.println(months + " " + days);

            result = TestName(months,days);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  result;

    }

    public long getMonths() {
        DateFormat m_ISO8601Local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date dateOfBirth= m_ISO8601Local.parse(dob);
            Date today = new Date();

            LocalDate ldateOfBirth = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ltoday = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long months =  ChronoUnit.MONTHS.between(ldateOfBirth,ltoday);
            return months;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String TestName(Long months, Long days){
        if(lowerLimit(57,0,months, days) && upperLimit(60, 30,months,days)){
            return "60 Meses ASQ-3";
        }else if(lowerLimit(51,0,months, days) && upperLimit(56, 30,months,days)){
            return "54 Meses ASQ-3";
        }else if(lowerLimit(45,0,months, days) && upperLimit(50, 30,months,days)){
            return "48 Meses ASQ-3";
        }else if(lowerLimit(39,0,months, days) && upperLimit(44, 30,months,days)){
            return "42 Meses ASQ-3";
        }else if(lowerLimit(34,16,months, days) && upperLimit(38, 30,months,days)){
            return "36 Meses ASQ-3";
        }else if(lowerLimit(31,16,months, days) && upperLimit(34, 15,months,days)){
            return "33 Meses ASQ-3";
        }else if(lowerLimit(28,16,months, days) && upperLimit(31, 15,months,days)){
            return "30 Meses ASQ-3";
        }else if(lowerLimit(25,16,months, days) && upperLimit(28, 15,months,days)){
            return "27 Meses ASQ-3";
        }else if(lowerLimit(23,0,months, days) && upperLimit(25, 15,months,days)){
            return "25 Meses ASQ-3";
        }else if(lowerLimit(21,0,months, days) && upperLimit(22, 30,months,days)){
            return "22 Meses ASQ-3";
        }else if(lowerLimit(19,0,months, days) && upperLimit(20, 30,months,days)){
            return "20 Meses ASQ-3";
        }else if(lowerLimit(17,0,months, days) && upperLimit(18, 30,months,days)){
            return "18 Meses ASQ-3";
        }else if(lowerLimit(15,0,months, days) && upperLimit(16, 30,months,days)){
            return "16 Meses ASQ-3";
        }else if(lowerLimit(13,0,months, days) && upperLimit(14, 30,months,days)){
            return "14 Meses ASQ-3";
        }else if(lowerLimit(11,0,months, days) && upperLimit(12, 30,months,days)){
            return "12 Meses ASQ-3";
        }else if(lowerLimit(10,0,months, days) && upperLimit(10, 30,months,days)){
            return "10 Meses ASQ-3";
        }else if(lowerLimit(9,0,months, days) && upperLimit(9, 30,months,days)){
            return "9 Meses ASQ-3";
        }else if(lowerLimit(7,0,months, days) && upperLimit(8, 30,months,days)){
            return "8 Meses ASQ-3";
        }else if(lowerLimit(5,0,months, days) && upperLimit(6, 30,months,days)){
            return "6 Meses ASQ-3";
        }else if(lowerLimit(3,0,months, days) && upperLimit(4, 30,months,days)){
            return "4 Meses ASQ-3";
        }else if(lowerLimit(1,0,months, days) && upperLimit(2, 30,months,days)){
            return "2 Meses ASQ-3";
        }

        return ("ninguno");


    }

    public boolean lowerLimit(int orMonths, int orDay, Long months, Long days){
        return orMonths < months  || (orMonths==months && orDay <= days);
    }

    public boolean upperLimit(int orMonths, int orDay, Long months, Long days){
        return orMonths > months  || (orMonths==months && orDay >= days);
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
