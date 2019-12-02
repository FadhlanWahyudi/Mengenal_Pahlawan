package com.example.mengenal_pahlawan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvfav;
    private MovieAdapter movieAdapter;

    ArrayList<ModelMovie> arrayList;
    private String[] id = {"Soedirman", "Soekarno", "Diponegoro",""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
