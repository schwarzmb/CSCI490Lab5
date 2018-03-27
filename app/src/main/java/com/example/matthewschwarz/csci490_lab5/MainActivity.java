package com.example.matthewschwarz.csci490_lab5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matthewschwarz.csci490_lab5.async.MyAsyncTask;
import com.example.matthewschwarz.csci490_lab5.async.MyAsyncTask2;
import com.example.matthewschwarz.csci490_lab5.data.LabDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "person_DB";
    Button submitButton;
    Button listButton;
    String text;
    EditText input;
    LabDatabase labDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();
        submitButton = findViewById(R.id.button);
        listButton = findViewById(R.id.button2);
        input = findViewById(R.id.editText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = String.valueOf(input.getText().toString());
                Toast.makeText(getApplicationContext(), "submit pressed", Toast.LENGTH_SHORT).show();
                submitToDatabase(input.getText().toString());
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String temp = String.valueOf((findViewById(R.id.editText)).toString());
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                retrieveName();

            }
        });


    }

    private void submitToDatabase(String name) {
        MyAsyncTask myAsyncTask = new MyAsyncTask(labDB, getApplicationContext());
        myAsyncTask.execute();
    }

    private void retrieveName() {
        MyAsyncTask2 myAsyncTask2 = new MyAsyncTask2(labDB, getApplicationContext());
        myAsyncTask2.execute();
    }
}
