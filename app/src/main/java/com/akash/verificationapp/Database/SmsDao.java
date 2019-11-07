package com.akash.verificationapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SmsDao {
    @Query("SELECT * FROM Sms")
    List<Sms> getAll();

    @Query("SELECT * FROM Sms WHERE id IN (:smsids)")
    List<Sms> loadAllByIds(int[] smsids);

    @Insert
    void insertAll(Sms... sms);

    @Delete
    void delete(Sms sms);
}
