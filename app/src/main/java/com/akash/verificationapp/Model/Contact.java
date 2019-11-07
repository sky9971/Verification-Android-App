package com.akash.verificationapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Contact implements Parcelable {

    private String firstName;
    private String lastName;
    private String phone;

    public Contact(JSONObject contact){
        try{
            this.firstName = contact.getString("first");
            this.lastName = contact.getString("last");
            this.phone = contact.getString("phone");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Contact(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(phone);
    }
}
