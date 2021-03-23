package com.example.inucalc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface gradesDAO {
    @Query("SELECT * FROM grades")
    LiveData<List<grades>> getAll();
    @Query("SELECT name,score,reInfo FROM grades WHERE score != 'A+' and score != 'A0' and score != 'B+' and score != 'B0'")
    public List<retakeTuple> retack();
    @Query("SELECT count (distinct semester) FROM grades ")
    Integer semCnt();
    @Query("SELECT reInfo FROM grades WHERE name=:name")
    public String loadReInfo(String name);
    @Query("UPDATE grades SET reInfo=:reInfo WHERE name=:name")
    public void setReInfo(String name, String reInfo);

    @Query("SELECT score FROM grades")
    LiveData<List<String>> getScore();
    @Query("SELECT SUM(point) FROM grades")
    LiveData<Integer> getPoint();
    @Query("SELECT score FROM grades WHERE sort='전선' or sort='전필'")
    LiveData<List<String>> getMajorScore();
    @Query("SELECT SUM(point) FROM grades WHERE sort='전선' or sort='전필'" )
    LiveData<Integer> getMajorPoint();
    @Query("SELECT score FROM grades WHERE sort='교선' or sort='교필'")
    LiveData<List<String>> getElecScore();
    @Query("SELECT SUM(point) FROM grades WHERE sort='교선' or sort='교필'" )
    LiveData<Integer> getElecPoint();
    @Insert
    void insert(grades db);
    @Update
    void update(grades db);
    @Delete
    void delete(grades db);

}
