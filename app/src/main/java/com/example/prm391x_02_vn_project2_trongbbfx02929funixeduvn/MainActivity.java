package com.example.prm391x_02_vn_project2_trongbbfx02929funixeduvn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khai báo thanh tiêu đề
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Tour Guide App");

        // Khai báo nút chọn ảnh
        final ImageButton hotel = findViewById(R.id.image_button_hotel);
        final ImageButton hospital = findViewById(R.id.image_button_hospital);
        final ImageButton atm = findViewById(R.id.image_button_atm);
        final ImageButton metro = findViewById(R.id.image_button_metro);

        // Khai báo đoạn đối tượng
        final Fragment fragmentHotel = new HotelFragment();
        final Fragment fragmentHospital = new HospitalFragment();
        final Fragment fragmentAtm = new AtmFragment();
        final Fragment fragmentMetro = new MetroFragment();

        // Nút hình ảnh hotel
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentHotel);
                fragmentTransaction.commit();
            }
        });

        // Nút hình ảnh hospital
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentHospital);
                fragmentTransaction.commit();
            }
        });

        // Nút hình ảnh atm
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentAtm);
                fragmentTransaction.commit();
            }
        });

        // Nút hình ảnh metro
        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentMetro);
                fragmentTransaction.commit();
            }
        });
    }
}