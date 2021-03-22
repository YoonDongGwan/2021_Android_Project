package com.example.inucalc;

public class percent {
    String grade;
    int percent;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public percent(int percent, String grade){
        this.grade = grade;
        this.percent = percent;
    }

}

