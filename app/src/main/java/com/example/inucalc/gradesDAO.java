package com.example.inucalc;

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
    @Query("SELECT score FROM grades")
    List<String> getScore();
    @Query("SELECT point FROM grades")
    List<Integer> getPoint();
    @Insert
    void insert(grades db);
    @Update
    void update(grades db);
    @Delete
    void delete(grades db);

}
