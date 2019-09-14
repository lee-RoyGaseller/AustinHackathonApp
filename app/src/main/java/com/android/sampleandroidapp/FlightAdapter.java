package com.android.sampleandroidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sampleandroidapp.dataModel.Flight;

import java.util.ArrayList;

class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {

    private ArrayList<Flight> mFlightList;

    public FlightAdapter(ArrayList<Flight> flightList) {
        mFlightList = flightList;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.flight_list_item, parent, false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        Flight flight = mFlightList.get(position);

        holder.origin_tv.setText(flight.getOrigin().getCode());
        holder.destination_tv.setText(flight.getDestination().getCode());
        holder.flight_number_tv.setText("Flight #" + flight.getFlightNumber());
    }

    @Override
    public int getItemCount() {
        return mFlightList.size();
    }

    class FlightViewHolder extends RecyclerView.ViewHolder {

        private TextView origin_tv;
        private TextView destination_tv;
        private TextView flight_number_tv;

        public FlightViewHolder(@NonNull View itemView) {
            super(itemView);

            origin_tv = itemView.findViewById(R.id.origin);
            destination_tv = itemView.findViewById(R.id.destination);
            flight_number_tv = itemView.findViewById(R.id.flight_number);
        }
    }
}
