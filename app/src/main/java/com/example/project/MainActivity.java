package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23erigu";

    private int whichSort = 0;

    private Button switchActivityButton;
    private Button sortAZButton;
    private Button sortZAButton;

    private RecyclerView recView;
    private RecyclerViewAdapter recViewAdapter;

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPreferenceRef = getSharedPreferences("MySortingPreference", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        new JsonTask(this).execute(JSON_URL);

        switchActivityButton = findViewById(R.id.switchActivityButton);
        sortAZButton = findViewById(R.id.sortAZButton);
        sortZAButton = findViewById(R.id.sortZAButton);


        switchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        sortAZButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recViewAdapter.sortAZ();
                recViewAdapter.notifyDataSetChanged();
                myPreferenceEditor.putInt("SortingPreference", 1);
                myPreferenceEditor.apply();
            }
        });

        sortZAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recViewAdapter.sortZA();
                recViewAdapter.notifyDataSetChanged();
                myPreferenceEditor.putInt("SortingPreference", 2);
                myPreferenceEditor.apply();
            }
        });

    }

    @Override
    public void onPostExecute(String json) {
        Type type = new TypeToken<ArrayList<Dog>>() {}.getType();
        ArrayList<Dog> listOfDogs = gson.fromJson(json, type);

        recViewAdapter = new RecyclerViewAdapter(this, listOfDogs, new RecyclerViewAdapter.OnClickListener(){
            @Override
            public void onClick(Dog dog) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", dog.getName());
                intent.putExtra("origin", dog.getOrigin());
                intent.putExtra("color", dog.getColor());
                intent.putExtra("racialGroup", dog.getRacialGroup());
                intent.putExtra("size", dog.getSize());
                intent.putExtra("cuteness", dog.getCuteness());
                intent.putExtra("picture", dog.getPicture());
                startActivity(intent);
            }
        });

        recView = findViewById(R.id.recycler_view);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(recViewAdapter);

        if (whichSort == 1){
            recViewAdapter.sortAZ();
        } else if (whichSort == 2) {
            recViewAdapter.sortZA();
        }

        recViewAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();

        whichSort = myPreferenceRef.getInt("SortingPreference", 0);
    }

}
