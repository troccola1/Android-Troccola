package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.addAlarm);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);
            startActivity(intent);
        });
    }
}