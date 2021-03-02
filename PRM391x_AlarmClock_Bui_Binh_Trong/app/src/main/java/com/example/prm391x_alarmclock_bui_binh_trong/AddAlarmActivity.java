package com.example.prm391x_alarmclock_bui_binh_trong;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAlarmActivity extends AppCompatActivity {
    @BindView(R.id.toolBarAdd)
    Toolbar toolBarAdd;
    @BindView(R.id.addAlarm)
    Button addAlarm;
    @BindView(R.id.time_Picker)
    TimePicker timePicker;
    @BindView(R.id.activityName)
    TextView activityName;
    @BindView(R.id.name_Alarm)
    EditText name_Alarm;

    private boolean addScreen;
    private Alarm alarmEdit;
    private Intent intentInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolBarAdd.setNavigationIcon(R.drawable.ic_back);
        setScreen();
        backPressed();
    }

    private void backPressed() {
        toolBarAdd.setNavigationOnClickListener(view -> {
            setResult(Constans.REQUEST_CANCEL);
            onBackPressed();
        });
    }

    private void setScreen() {
        intentInfor = getIntent();
        String screenType = intentInfor.getStringExtra("screenType");
        assert screenType != null;
        if (screenType.contains("add")) {
            activityName.setText(R.string.add);
            addAlarm.setText(R.string.add);
            addScreen = true;
        } else if (screenType.contains("edit")) {
            try {
                alarmEdit = (Alarm) Objects.requireNonNull(intentInfor.getExtras()).getSerializable("AlarmEdit");
            } catch ()
        }
    }

    // TODO: process when user press ADD or EDIT button
    @OnClick(R.id.addAlarm)
    public void onClick(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        Alarm alarm = initAlarm();

        if (addScreen) {
            alarm.setmId((int) System.currentTimeMillis());
            intent.putExtra("Alarm", alarm);
            setResult(RESULT_OK, intent);
            finish();

        } else {
            int position = Objects.requireNonNull(intentInfor.getExtras()).getInt("position");

            String name = alarm.getmAlarmName();
            int hour = alarm.getmHour();
            int minute = alarm.getmMinute();

            alarmEdit.setmAlarmName(name);
            alarmEdit.setmHour(hour);
            alarmEdit.setmMinute(minute);

            // sending it back by Bundle, this Bundle should be used if
            // we need to transfer a big data, this transfer all detail at a time
            Bundle bundle = new Bundle();
            bundle.putSerializable("Alarm", alarmEdit);
            bundle.putInt("position", position);

            intent.putExtras(bundle);
            // set result for this activity
            setResult(RESULT_OK, intent);
            // finish method is requires if this Activity was started by startActivityForResult
            finish();
        }
    }

    // TODO:  this return alarm from timePicker set toggle on by default
    private Alarm initAlarm() {
        // set toggle on by default, 1 is on and 0 is off
        int toggleOn = 1;
        Alarm alarm;
        String name1 = null;
        // get current time from timePicker
        int hour = 0;
        int minute = 0;

        try {
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
            // get name for alarm from EditText
            String name = name_Alarm.getText().toString();

            if (name.length() == 0) {
                // if alarm'name is not inputted set the EditText'hint for alarm's name by default
                name1 = name_Alarm.getHint().toString();
            } else {
                name1 = name_Alarm.getText().toString();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        // initialize and assign alarm values
        alarm = new Alarm(hour, minute, name1, toggleOn);
        return alarm;
    }
}

