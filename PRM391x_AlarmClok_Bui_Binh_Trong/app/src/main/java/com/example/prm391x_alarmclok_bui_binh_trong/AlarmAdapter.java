package com.example.prm391x_alarmclok_bui_binh_trong;

import android.content.Intent;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mylist, parent, false);
        return new TimeViewHoder(view, mCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  TimeViewHolder) {
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

        @BindView(R.id.time_Alarm)
        TextView time;
        @BindView(R.id.alarm_Name)
        TextView title;
        @BindView(R.id.toggle_Alarm)
        TextView toggleButton;

        protected TimeViewHolder(View itemView, Callback CallBack) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mCallBack = CallBack;
            itemView.setOnCreateContextMenuListener(this);
        }

        @OnClick(R.id.toggle_Alarm)
        void onToggleClicked() {
            boolean isChecked = toggleButton.isChecked();
            if (isChecked) {
                time.setTextColor(Color.rgb(255,51,51));
                mCallBack.startAlarm(mAlarm.get(getLayoutPosition()));
            }
         }

         private void bindView(Alarm alarm) {
            time.setText(getStringFromTime(alarm));

            title.setText(alarm.getmAlarmName());
            int onOff = alarm.getmOnOff();
            switch (onOff) {
                case 1:
                    toggleButton.setChecked(true);
                    time.setTextColor(Color.rgb(255, 51, 51));
                    break;
                case 0:
                    toggleButton.setChecked(false);
                    time.setTextColor(Color.rgb(155, 155, 155));
                    break;
            }
         }

        private String getStringFromTime(Alarm alarm) {
            int minute = alarm.getmMinute(); // minute of alarm
            int hourSource = alarm.getmHour(); // hour of alarm
            int hour; // this hold time for time at AM, PM format
            String hour_x; // append 0 in front of hour if hour less than 10
            String minute_x; // append 0 in front of minute if minute less than 10
            String format;      // format for alarm

            if (hourSource == 0) {
                hour = hourSource + 12;
                format = "AM";
            } else if (hourSource == 12) {
                hour = hourSource;
                format = "PM";
            } else if (hourSource > 12) {
                hour = hourSource - 12;
                format = "PM";
            } else {
                hour = hourSource;
                format = "AM";
            }

            if (hour < 10) {
                hour_x = "0" + hour;
            } else {
                hour_x = "" + hour;
            }

            if (minute < 10) {
                minute_x = "0" + minute;
            } else {
                minute_x = "" + minute;
            }
            return hour_x + " : " + minute_x + "    " + format;
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());
            popup.setOnMenuItemClickListener(this);
            popup.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int position = getLayoutPosition();
            mCallBack.onMenuAction(mAlarm.get(position), menuItem, position);
            return false;
        }
    }

    void add(Alarm alarm) {
        mAlarm.add(alarm);
    }

    void updateAlarm(Alarm alarm, int position) {
        mAlarm.remove(position);
        mAlarm.add(position, alarm);
    }

    void remoteAlarm(int position) {
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
