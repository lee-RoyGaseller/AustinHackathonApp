package com.android.sampleandroidapp.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Duration implements Parcelable {

    private String locale;
    private int hours;
    private int minutes;

    protected Duration(Parcel in) {
        locale = in.readString();
        hours = in.readInt();
        minutes = in.readInt();
    }

    public static final Creator<Duration> CREATOR = new Creator<Duration>() {
        @Override
        public Duration createFromParcel(Parcel in) {
            return new Duration(in);
        }

        @Override
        public Duration[] newArray(int size) {
            return new Duration[size];
        }
    };

    public String getLocale() {
        return locale;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(locale);
        parcel.writeInt(hours);
        parcel.writeInt(minutes);
    }
}
