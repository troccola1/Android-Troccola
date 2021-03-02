package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddAlarmActivity extends AppCompatActivity {
    Button btnHenGio, btnDungLai;
    TextView txtHienThi;
    TimePicker timePicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        btnHenGio = (Button) findViewById(R.id.btnHenGio);
        btnDungLai = (Button) findViewById(R.id.btnDungLai);
        txtHienThi = (TextView) findViewById(R.id.textView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();

        btnHenGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();

                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);

                if (gio > 12) {
                    string_gio = String.valueOf(gio - 12);
                }
                if (phut < 10) {
                    string_phut = "0" + String.valueOf(phut);
                }

                txtHienThi.setText("Giờ bạn đặt là " + string_gio + ":" + string_phut);

//                TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
//                TextView textView = (TextView) findViewById(R.id.textView);
//                int h = timePicker.getCurrentHour();
//                String hour = "" + h;
//                String format = "AM";
//                if (h < 10) {
//                    hour = "0" + h;
//                }
//
//                if (h == 12) {
//                    format = "PM";
//                }
//
//                if (h > 12) {
//                    format = "PM";
//                    hour = "0" + (h - 12);
//                }
//                textView.setText("Giờ hiển thị của bạn là " + hour + ":" + timePicker.getCurrentMinute().toString() + " " + format);
            }
        });

        btnDungLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHienThi.setText("Dừng lại");
            }
        });
    }
}