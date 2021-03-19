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
    List<grades> getAll();
    @Query("SELECT name,score FROM grades WHERE score != 'A+' and score != 'A0' and score != 'B+' and score != 'B0'")
    public List<retakeTuple> retack();
    @Query("SELECT count (distinct semester) FROM grades ")
    Integer semCnt();
    @Insert
    void insert(grades db);
    @Update
    void update(grades db);
    @Delete
    void delete(grades db);

}
