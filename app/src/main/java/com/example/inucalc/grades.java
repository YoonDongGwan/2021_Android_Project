package com.example.inucalc;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class grades {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String name;
    private String semester;
    private String score;
    private String sort;
    private int point;


    public grades(String semester, String name, String sort, String score, int point){
        this.semester = semester;
        this.name = name;
        this.sort = sort;
        this.score = score;
        this.point = point;
    }

    public String getSemester() {
        return semester;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getSort() {
        return sort;
    }

    public int getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(String grade) {
        this.score = score;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "grades{" + id + '\'' +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", score='" + score + '\'' +
                ", sort='" + sort + '\'' +
                ", point=" + point +
                '}';
    }
}
