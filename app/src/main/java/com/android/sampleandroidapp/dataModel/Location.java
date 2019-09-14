package com.android.sampleandroidapp.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

class Location implements Parcelable {

    private String latitude;
    private String longitude;

    protected Location(Parcel in) {
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(latitude);
        parcel.writeString(longitude);
    }
}
