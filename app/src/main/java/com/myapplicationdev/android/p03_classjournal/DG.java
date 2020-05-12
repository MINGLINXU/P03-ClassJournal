package com.myapplicationdev.android.p03_classjournal;

import java.io.Serializable;

public class DG implements Serializable {
    private String DailyGrade;
    private String week;


    public DG(String week, String dailyGrade){
        this.DailyGrade  = dailyGrade;
        this.week = week;
    }



    public String getDailyGrade() {
        return DailyGrade;
    }

    public String getWeek() {
        return week;
    }
}
