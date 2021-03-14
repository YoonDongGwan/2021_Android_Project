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
    @Insert
    void insert(grades db);
    @Update
    void update(grades db);
    @Delete
    void delete(grades db);

}
