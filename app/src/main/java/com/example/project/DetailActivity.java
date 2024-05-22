package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView raceTextView;
    TextView cutnessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTextView = findViewById(R.id.nameTextView);
        raceTextView = findViewById(R.id.raceTextView);
        cutnessTextView = findViewById(R.id.cutnessTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String origin = extras.getString("origin");
            String color = extras.getString("color");
            String racialGroup = extras.getString("racialGroup");
            String size = extras.getString("size");
            String cuteness = extras.getString("cuteness");
            String picture = extras.getString("picture");
            // Do something with the name and number
            nameTextView.setText(name);
            raceTextView.setText(racialGroup);
            cutnessTextView.setText(cuteness + "/10");
        }

    }
}