package com.example.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Breaking News button function
    public void btnNew(View view) {
        Intent toNews = new Intent(this, BreakingNews.class);
        startActivity(toNews);
    }

    // COVID Map button function
    public void btnMap(View view) {
        Intent toMap =new Intent(this,MapActivity.class);
        startActivity(toMap);
    }

    // Search button function
    public void btnSearch(View view) {
        Intent toSearch =new Intent(this,SearchActivity.class);
        startActivity(toSearch);
    }
}