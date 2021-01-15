package com.example.prm391x_02_vn_project1_trongbbfx02929funixeduvn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioButton r_a, r_b, r_c;
    Button test;
    TextView mgs;
    CheckBox int_id, double_id, string_id, all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_a = findViewById(R.id.radio_a);
        r_b = findViewById(R.id.radio_b);
        r_c = findViewById(R.id.radio_c);

        r_a.setOnCheckedChangeListener(listenerRadio);
        r_b.setOnCheckedChangeListener(listenerRadio);
        r_c.setOnCheckedChangeListener(listenerRadio);

        test = findViewById(R.id.test);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r_b.isChecked()) {
                    mgs.setText("Đúng rồi");
                } else {
                    mgs.setText("Sai");
                }
            }
        });
        init();

    }

    CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            test.setEnabled(true);
            if (isChecked) {
                mgs.setText("Bạn chọn: " + buttonView.getText());
            }
        }
    };

    //Listener nhận sự kiện khi các Checkbox thay đổi trạng thái
    CompoundButton.OnCheckedChangeListener m_listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton == all)
            {
                detachListener();
                int_id.setEnabled(!b);
                double_id.setEnabled(!b);
                string_id.setEnabled(!b);

                int_id.setChecked(b);
                double_id.setChecked(b);
                string_id.setChecked(b);
                attachListener();
            }
            else {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText() + " | "
                                + compoundButton.isChecked(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    //Gán Listener vào CheckBox
    void attachListener()
    {
        int_id.setOnCheckedChangeListener(m_listener);
        double_id.setOnCheckedChangeListener(m_listener);
        string_id.setOnCheckedChangeListener(m_listener);
        all.setOnCheckedChangeListener(m_listener);

    }
    //Bỏ các Listener khỏi CheckBox
    void detachListener()
    {
        int_id.setOnCheckedChangeListener(null);
        double_id.setOnCheckedChangeListener(null);
        string_id.setOnCheckedChangeListener(null);
        all.setOnCheckedChangeListener(null);

    }


    void init() {
        int_id    = findViewById(R.id.int_id);
        double_id = findViewById(R.id.double_id);
        string_id = findViewById(R.id.string_id);
        all       = findViewById(R.id.all);
        attachListener();


        test = findViewById(R.id.test);

        test.setOnClickListener(view -> {
            String mgs = "";
            if (!int_id.isChecked() &&
                    !double_id.isChecked() &&
                    string_id.isChecked())
                mgs = "Đúng rồi";
            else
                mgs = "Sai";

            Toast.makeText(view.getContext(),
                    mgs,
                    Toast.LENGTH_SHORT).show();
        });
    }

}