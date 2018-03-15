package com.example.matthewschwarz.csci490_lab5.async;

import android.os.AsyncTask;

import com.example.matthewschwarz.csci490_lab5.data.LabDatabase;
import com.example.matthewschwarz.csci490_lab5.entities.Person;

/**
 * Created by matthewschwarz on 3/15/18.
 */

public class MyAsyncTask extends AsyncTask<String, Void, Void> {
    LabDatabase database;

    public MyAsyncTask(LabDatabase database){
        this.database = database;
    }
    @Override
    protected Void doInBackground(String... strings){
        Person person = new Person();
        person.setName(strings[0]);
        database.personDao().insertPerson(person);
        return null;
    }
}
