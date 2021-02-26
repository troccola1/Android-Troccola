package com.example.prm391x_alarmclok_bui_binh_trong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.AlarmClock;

public class MainActivity extends AppCompatActivity implements AlarmClock.CallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}