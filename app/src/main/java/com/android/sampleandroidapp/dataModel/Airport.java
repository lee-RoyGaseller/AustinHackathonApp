package com.android.sampleandroidapp.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Airport implements Parcelable {

    private String code;
    private String city;
    private Location location;

    protected Airport(Parcel in) {
        code = in.readString();
        city = in.readString();
    }

    public static final Creator<Airport> CREATOR = new Creator<Airport>() {
        @Override
        public Airport createFromParcel(Parcel in) {
            return new Airport(in);
        }

        @Override
        public Airport[] newArray(int size) {
            return new Airport[size];
        }
    };

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(city);
    }
}
