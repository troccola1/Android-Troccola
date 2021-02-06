package com.example.prm391x_02_vn_project2_trongbbfx02929funixeduvn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AtmFragment extends Fragment {

    // Khai báo list view(danh sách)
    ListView simpleList;
    // Khai báo metro list(danh sách)
    ArrayList<Item> atmlList = new ArrayList<Item>();

    // Return a View component
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atm, container, false);
        simpleList = view.findViewById(R.id.list_atm);
        atmlList.add(new Item(R.drawable.atm_machine, "ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội"));
        atmlList.add(new Item(R.drawable.atm_machine, "ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội"));
        atmlList.add(new Item(R.drawable.atm_machine, "ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội"));

        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.mylist, atmlList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(getContext(), "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Toast.makeText(getContext(), "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(getContext(), "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}