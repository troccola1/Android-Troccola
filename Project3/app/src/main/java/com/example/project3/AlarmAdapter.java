package com.example.project3;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter {
    private ArrayList<Alarm> mAlarm;
    private CallBack mCallBack;

    public interface CallBack {
        void onMenuAction(Alarm alarm, MenuItem item, int position);

        void startAlarm(Alarm timeItem);

        void cancelAlarm(Alarm timeItem);
    }

    AlarmAdapter(ArrayList<Alarm> mAlarm, CallBack mCallBack) {
        this.mAlarm = mAlarm;
        this.mCallBack = mCallBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mylist, parent, false);
        return new TimeViewHolder(view, mCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TimeViewHolder) {
            TimeViewHolder timeViewHolder = (TimeViewHolder) holder;
            timeViewHolder.bindView(mAlarm.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mAlarm.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,
            PopupMenu.OnMenuItemClickListener {

        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }

        public void bindView(Alarm alarm) {
        }
    }

    void add(Alarm alarm) {
        mAlarm.add(alarm);
    }

    void updateAlarm(Alarm alarm, int position) {
        mAlarm.remove(position);
        mAlarm.add(position, alarm);
    }

    void removeAlarm(int position) {
        try {
            mAlarm.remove(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<Alarm> getmAlarm() {
        return mAlarm;
    }
}
