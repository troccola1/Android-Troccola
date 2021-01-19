package com.example.prm391x_02_vn_project1_trongbbfx02929funixeduvn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioButton c_1_a, c_1_b, c_1_c, c_4_a, c_4_b, c_5_a, c_5_b, c_5_c, c_5_d;
    Button test;
    TextView mgs;
    CheckBox c_2_a, c_2_b, c_2_c, c_2_d;
    EditText c_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lưu lại số câu trả lời đúng
                int i = 0;
                // câu hỏi 1
                c_1_a = findViewById(R.id.c_1_a);
                c_1_b = findViewById(R.id.c_1_b);
                c_1_c = findViewById(R.id.c_1_c);
                // Kiểm tra câu trả lời có đúng ko(nếu đúng thì tăng thêm 1 đơn vị)
                if (c_1_b.isChecked()) {
                    i++;
                }

                // câu hỏi 2
                c_2_a = findViewById(R.id.c_2_a);
                c_2_b = findViewById(R.id.c_2_b);
                c_2_c = findViewById(R.id.c_2_c);
                c_2_d = findViewById(R.id.c_2_d);

                if (c_2_a.isChecked() && c_2_b.isChecked() && c_2_c.isChecked() && !c_2_d.isChecked()) {
                    i++;
                }

                // câu hỏi 3
                c_3 = findViewById(R.id.c_3);
                String kq = "Hà Nội";
                if(c_3.length() == kq.length()) {
                    i++;
                }

                // câu hỏi 4
                c_4_a = findViewById(R.id.c_4_a);
                c_4_b = findViewById(R.id.c_4_b);

                if (c_4_a.isChecked()) {
                    i++;
                }

                // Câu hỏi 5
                c_5_a = findViewById(R.id.c_5_a);
                c_5_b = findViewById(R.id.c_5_b);
                c_5_c = findViewById(R.id.c_5_c);
                c_5_d = findViewById(R.id.c_5_d);
                if (c_5_b.isChecked()) {
                    i++;
                }

                Toast.makeText(view.getContext(), "Bạn đã đúng " + i + " câu ^.^", Toast.LENGTH_SHORT).show();
            }
        });
    }
}