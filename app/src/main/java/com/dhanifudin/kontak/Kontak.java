package com.dhanifudin.kontak;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dhanifudin on 11/18/17.
 */

public class Kontak implements Parcelable {
    private String nama;
    private String gender;

    public Kontak(String nama, String gender) {
        this.nama = nama;
        this.gender = gender;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.gender);
    }

    protected Kontak(Parcel in) {
        this.nama = in.readString();
        this.gender = in.readString();
    }

    public static final Parcelable.Creator<Kontak> CREATOR = new Parcelable.Creator<Kontak>() {
        @Override
        public Kontak createFromParcel(Parcel source) {
            return new Kontak(source);
        }

        @Override
        public Kontak[] newArray(int size) {
            return new Kontak[size];
        }
    };
}
