package com.example.project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView raceTextView;
    TextView cutenessTextView;
    ImageView dogImageView;
    TextView colorTextView;
    TextView originTextView;
    TextView sizeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTextView = findViewById(R.id.nameTextView);
        raceTextView = findViewById(R.id.raceTextView);
        cutenessTextView = findViewById(R.id.cutenessTextView);
        dogImageView = findViewById(R.id.dogImageView);
        colorTextView = findViewById(R.id.colorTextView);
        originTextView = findViewById(R.id.originTextView);
        sizeTextView = findViewById(R.id.sizeTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String origin = extras.getString("origin");
            String color = extras.getString("color");
            String racialGroup = extras.getString("racialGroup");
            int size = extras.getInt("size");
            int cuteness = extras.getInt("cuteness");
            String picture = extras.getString("picture");

            nameTextView.setText(name);
            raceTextView.setText(racialGroup);
            Glide.with(this).load(picture).into(dogImageView);
            cutenessTextView.setText(cuteness + "/10");
            colorTextView.setText(color);
            originTextView.setText(origin);
            sizeTextView.setText("The dogs size is " + size);


        }

    }
}