package com.example.vienahoteldev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Restaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_restaurante);
    }
}