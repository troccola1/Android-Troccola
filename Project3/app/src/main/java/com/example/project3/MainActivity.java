package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //khai bao 1 recyclerview
    private DataBaseManager mDataBaseManager;
    private AlarmAdapter mAlarmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.addAlarm);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);
            startActivity(intent);
        });
        //listview/ recyclerview -> hien thi danh sach
    }

    private void initView() {
        // set layout for recycle view
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        importData();
        // set adapter for recycle view
        recyclerView.setAdapter(mAlarmAdapter);
    }

    private void importData() {
        // if alarmAdapter null it's means data have not imported, yet or database is empty
        if (mAlarmAdapter == null) {
            // initialize database manager
            mDataBaseManager = new DataBaseManager(this);
            // get Alarm ArrayList from database
            ArrayList<Alarm> arrayList = mDataBaseManager.getAlarmList();
            // create Alarm adapter to display detail through RecyclerView
            mAlarmAdapter = new AlarmAdapter(arrayList, this);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        // lay du lieu alarm tu local db -> hien thi danh sach tren man hinh
        // tim hieu cach su dung sqlite
        //tim hieu cach su dung recyclerview

    }
}