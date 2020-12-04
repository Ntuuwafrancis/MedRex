package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.Prescription;

import java.util.List;

@Dao
public interface PrescriptionDao {

    @Insert
    void insert(Prescription prescription);

    @Update
    void update(Prescription prescription);

    @Delete
    void delete(Prescription prescription);

    @Query("DELETE FROM prescriptions")
    void deleteAllPrescriptions();

    @Query("SELECT * FROM prescriptions")
    LiveData<List<Prescription>> getAllPrescriptions();
}
