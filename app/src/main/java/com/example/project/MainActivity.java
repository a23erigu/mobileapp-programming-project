package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button switchActivityButton;

    private ArrayList<Dog> Dogs;

    private RecyclerView recView;
    private RecyclerViewAdapter recViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Dogs = new ArrayList<>(Arrays.asList(
                new Dog("Golden retriver"),
                new Dog("Siberien husky"),
                new Dog("Border coly")
        ));

        recViewAdapter = new RecyclerViewAdapter(this, Dogs);

        recView = findViewById(R.id.recycler_view);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(recViewAdapter);

        switchActivityButton = findViewById(R.id.switchActivityButton);

        switchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }

}
