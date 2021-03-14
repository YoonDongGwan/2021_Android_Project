package com.example.inucalc;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {grades.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract gradesDAO gradesDAO();
}
