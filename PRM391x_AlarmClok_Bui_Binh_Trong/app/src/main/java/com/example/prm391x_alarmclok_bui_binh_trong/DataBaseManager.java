package com.example.prm391x_alarmclok_bui_binh_trong;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAM = "db_alarm";
    private static final String TABLE_NAME = "alarm";
    private static final String KEY_ID = "id";
    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTE = "minute";
    private static final String KEY_NAM = "alarm_name";
    private static final String KEY_TOGGLE = "toggle";

    private static final String CREATE_TABLE_ALARM = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + "INTEGER, "
            + KEY_HOUR + "INTEGER, "
            + KEY_MINUTE + "INTEGER, "
            + KEY_NAM + "TEXT, "
            + KEY_TOGGLE + "INTEGER )";

    DataBaseManager(@Nullable Context context) {
        super(context, DATABASE_NAM, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ALARM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", CREATE_TABLE_ALARM));
        onCreate(sqLiteDatabase);
    }

    void addAlarm(Alarm alarm) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put(KEY_ID, alarm.getmId());
        }
    }
}
