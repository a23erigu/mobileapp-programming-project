package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    TextView nameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameView = findViewById(R.id.nameView);

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
            nameView.setText(name);
        }

    }
}