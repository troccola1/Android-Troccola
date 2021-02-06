package com.example.prm391x_02_vn_project2_trongbbfx02929funixeduvn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MetroFragment extends Fragment {

    // Khai báo list view(danh sách)
    ListView simpleList;
    // Khai báo metro list(danh sách)
    ArrayList<Item> metrolList = new ArrayList<Item>();

    // Return a View component
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_metro, container, false);
        simpleList = view.findViewById(R.id.list_metro);
        metrolList.add(new Item(R.drawable.metro, "Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa"));
        metrolList.add(new Item(R.drawable.metro, "Tuyến 03A", "BX Giáp Bát - BX Gia Lâm"));
        metrolList.add(new Item(R.drawable.metro, "Tuyến 08", "Long Biên - Đông Mỹ"));
        // Declare the class MyAdapter object myAdapter
        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.mylist, metrolList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(getContext(), "BX Gia Lâm - BX Yên Nghĩa", Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Toast.makeText(getContext(), "BX Giáp Bát - BX Gia Lâm", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(getContext(), "Long Biên - Đông Mỹ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
