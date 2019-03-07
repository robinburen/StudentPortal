package com.example.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class Portal implements Parcelable {
    private String mPortalText;
    private String mPortalUrl;

    public Portal(String mPortalText, String mPortalUrl) {
        this.mPortalText = mPortalText;
        this.mPortalUrl = mPortalUrl;
    }

    public String getmPortalText() {
        return mPortalText;
    }

    public void setmPortalText(String mPortalText) {
        this.mPortalText = mPortalText;
    }

    public String getmPortalUrl() {
        return mPortalUrl;
    }

    public void setmPortalUrl(String mPortalUrl) {
        this.mPortalUrl = mPortalUrl;
    }

    @Override
    public String toString() {
        return mPortalText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPortalText);
        dest.writeString(this.mPortalUrl);
    }

    protected Portal(Parcel in) {
        this.mPortalText = in.readString();
        this.mPortalUrl = in.readString();
    }

    public static final Parcelable.Creator<Portal> CREATOR = new Parcelable.Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };
}
