package com.android.sampleandroidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sampleandroidapp.dataModel.Flight;

import java.util.ArrayList;

public class FlightListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Flight> mFlightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        mFlightList = getIntent().getParcelableArrayListExtra(MainActivity.EXTRA_FLIGHT_LIST);

        mRecyclerView = findViewById(R.id.flights_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new FlightAdapter(mFlightList));
    }

}
