package com.example.prm391x_alarmclok_bui_binh_trong;

import android.content.Intent;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class AlarmAdapter extends RecyclerView.Adapter {
    private ArrayList<Alarm> mAlarm;
    private Callback mCallBack;

    public interface CallBack {
        void onMenuAction(Alarm alarm, MenuItem item, int position);

        void startAlarm(Alarm timeItem);

        void cancelAlarm(Alarm timeItem);
    }

    AlarmAdapter(ArrayList<Alarm> mAlarm, Callback mCallBack) {
        this.mAlarm = mAlarm;
        this.mCallBack = mCallBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
