package com.example.prm391x_alarmclok_bui_binh_trong;

import java.io.Serializable;

/**
 * this is Alarm class present for alarm object implements
 * Serializable to support in transfer object Alarm
 * through intent
 */

public class Alarm implements Serializable {
    // alarm's id this was create at the adding time
    private int mId;
    // alarm's hour
    private int mHour;
    // alarm's minute
    private int mMinute;
    // alarm's name
    private String mAlarmName;
    // alarm's on off
    private int mOnOff;

    // TODO: first constructor is used at the import data from database
    Alarm(int mId, int mHour, int mMinute, String mAlarmName, int mOnOff) {
        this.setmId(mId);
        this.setmHour(mHour);
        this.setmMinute(mMinute);
        this.setmAlarmName(mAlarmName);
        this.setmOnOff(mOnOff);
    }

    // TODO: second constructor is used at the add or edit time in the initAlarm method
    Alarm(int mHour, int mMinute, String mAlarmName, int mOnOff) {
        this.setmHour(mHour);
        this.setmMinute(mMinute);
        this.setmAlarmName(mAlarmName);
        this.setmOnOff(mOnOff);
    }

    public int getmHour() {
        return mHour;
    }

    public void setmHour(int mHour) {
        this.mHour = mHour;
    }

    public int getmMinute() {
        return mMinute;
    }

    public void setmMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public String getmAlarmName() {
        return mAlarmName;
    }

    public void setmAlarmName(String mAlarmName) {
        this.mAlarmName = mAlarmName;
    }

    public int getmOnOff() {
        return mOnOff;
    }

    public void setmOnOff(int mOnOff) {
        this.mOnOff = mOnOff;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
