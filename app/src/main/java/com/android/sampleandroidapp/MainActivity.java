package com.android.sampleandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.sampleandroidapp.dataModel.Flight;
import com.android.sampleandroidapp.network.FlightDataService;
import com.android.sampleandroidapp.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FLIGHT_LIST = "extra_flight_list";
    private ArrayList<Flight> mFlightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner fromAirportSpinner = findViewById(R.id.from_airport);
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this,
                R.array.from_airports_array, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromAirportSpinner.setAdapter(fromAdapter);

        Spinner toAirportSpinner = findViewById(R.id. to_airport);
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this,
                R.array.to_airports_array, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toAirportSpinner.setAdapter(toAdapter);

        Button findFlightsButton = findViewById(R.id.find_flights_button);
        findFlightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchFlightData();
            }
        });
    }

    private void fetchFlightData() {
        FlightDataService service = RetrofitInstance.getRetrofitInstance().create(FlightDataService.class);
        Call<ArrayList<Flight>> call = service.getFlights();
        if (!TextUtils.isEmpty(call.request().url().toString())) {
            Log.d("URL Called", call.request().url() + "");
        }

        call.enqueue(new Callback<ArrayList<Flight>>() {
            @Override
            public void onResponse(Call<ArrayList<Flight>> call, Response<ArrayList<Flight>> response) {
                mFlightList = response.body();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startFlightListActivity();
                    }
                });
            }

            @Override
            public void onFailure(Call<ArrayList<Flight>> call, Throwable t) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void startFlightListActivity() {
        if(mFlightList != null) {
            Intent intent = new Intent(this, FlightListActivity.class);
            intent.putParcelableArrayListExtra(EXTRA_FLIGHT_LIST, mFlightList);
            startActivity(intent);
        }
    }
}
