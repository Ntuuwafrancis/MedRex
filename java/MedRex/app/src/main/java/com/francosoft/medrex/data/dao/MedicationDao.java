package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.Medication;

import java.util.List;

@Dao
public interface MedicationDao {

    @Insert
    void insert(Medication medication);

    @Update
    void update(Medication medication);

    @Delete
    void delete(Medication medication);

    @Query("DELETE FROM medications")
    void deleteAllMedications();

    @Query("SELECT * FROM medications")
    LiveData<List<Medication>> getAllMedications();
}
