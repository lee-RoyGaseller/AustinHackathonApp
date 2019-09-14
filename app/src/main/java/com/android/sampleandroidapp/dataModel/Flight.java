package com.android.sampleandroidapp.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Flight implements Parcelable {

    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private int distance;
    private Duration duration;

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.flightNumber);
        dest.writeParcelable(this.origin, flags);
        dest.writeParcelable(this.destination, flags);
        dest.writeInt(this.distance);
        dest.writeParcelable(this.duration, flags);
    }

    protected Flight(Parcel in) {
        this.flightNumber = in.readString();
        this.origin = in.readParcelable(Airport.class.getClassLoader());
        this.destination = in.readParcelable(Airport.class.getClassLoader());
        this.distance = in.readInt();
        this.duration = in.readParcelable(Duration.class.getClassLoader());
    }

    public static final Parcelable.Creator<Flight> CREATOR = new Parcelable.Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel source) {
            return new Flight(source);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };
}
