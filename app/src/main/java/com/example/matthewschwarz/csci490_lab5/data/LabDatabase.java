package com.example.matthewschwarz.csci490_lab5.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.matthewschwarz.csci490_lab5.entities.Person;

/**
 * Created by matthewschwarz on 3/15/18.
 */
@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase{

    public abstract PersonDao personDao();

}
