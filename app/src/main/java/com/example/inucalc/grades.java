package com.example.inucalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    @Nullable
    private String reInfo=null;

    public grades(@NonNull String semester,String name, String sort, String score,  int point) {
        this.name = name;
        this.semester = semester;
        this.score = score;
        this.sort = sort;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Nullable
    public String getReInfo() {
        return reInfo;
    }

    public void setReInfo(@Nullable String reInfo) {
        this.reInfo = reInfo;
    }
}
