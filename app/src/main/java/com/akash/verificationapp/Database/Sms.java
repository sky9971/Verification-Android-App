package com.akash.verificationapp.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sms {
    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name = "body")
    public String body;

    @ColumnInfo(name = "to")
    public String to;

    @ColumnInfo(name = "from")
    public String from;

    @ColumnInfo(name = "date_time")
    public String data_time;


}
