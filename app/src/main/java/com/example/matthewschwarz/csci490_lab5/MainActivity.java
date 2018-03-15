package com.example.matthewschwarz.csci490_lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button listButton;
    String text;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.button);
        listButton = findViewById(R.id.button2);
        input = findViewById(R.id.editText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = String.valueOf(input.getText().toString());
                Toast.makeText(getApplicationContext(), "submit pressed", Toast.LENGTH_SHORT).show();
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String temp = String.valueOf((findViewById(R.id.editText)).toString());
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
