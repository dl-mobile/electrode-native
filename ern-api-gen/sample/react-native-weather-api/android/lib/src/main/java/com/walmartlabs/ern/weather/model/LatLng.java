package com.walmartlabs.ern.weather.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class LatLng implements Parcelable {

    private static final String KEY_BUNDLE_LATLNG = "latLng";

    @Nullable
    public static LatLng fromBundle(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }

        Parcelable parcelable = bundle.getParcelable(KEY_BUNDLE_LATLNG);
        if (parcelable instanceof LatLng) {
            return (LatLng) parcelable;
        } else {
            return null;
        }
    }

    private final Integer lat;
    private final Integer lng;
    private final String name;

    private LatLng(Builder builder) {
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.name = builder.name;
    }

    private LatLng(Parcel in) {
        lat = in.readInt();
        lng = in.readInt();
        name = in.readString();
    }

    public static final Creator<LatLng> CREATOR = new Creator<LatLng>() {
        @Override
        public LatLng createFromParcel(Parcel in) {
            return new LatLng(in);
        }

        @Override
        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };

    @NonNull
    public Integer getLat() {
        return lat;
    }

    @NonNull
    public Integer getLng() {
        return lng;
    }

    @Nullable
    public String getName() {
        return name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lat);
        dest.writeInt(lng);
        dest.writeString(name);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BUNDLE_LATLNG, this);
        return bundle;
    }

    public static class Builder {
        private final Integer lat;
        private final Integer lng;
        private String name;

        public Builder(@NonNull Integer lat, @NonNull Integer lng) {
            this.lat = lat;
            this.lng = lng;
        }

        @NonNull
        public Builder name(@Nullable String name) {
            this.name = name;
            return this;
        }

        @NonNull
        public LatLng build() {
            return new LatLng(this);
        }
    }
}
