package com.android.sampleandroidapp.network;

import com.android.sampleandroidapp.dataModel.Flight;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlightDataService {

    @GET("/flights")
    Call<ArrayList<Flight>> getFlights();

}
