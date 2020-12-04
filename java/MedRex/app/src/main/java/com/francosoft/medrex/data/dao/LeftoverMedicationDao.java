package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.LeftoverMedication;

import java.util.List;

@Dao
public interface LeftoverMedicationDao {

    @Insert
    void insert(LeftoverMedication leftoverMedication);

    @Update
    void update(LeftoverMedication leftoverMedication);

    @Delete
    void delete(LeftoverMedication leftoverMedication);

    @Query("DELETE FROM leftover_medications")
    void deleteAllLeftoverMedications();

    @Query("SELECT * FROM leftover_medications")
    LiveData<List<LeftoverMedication>> getAllLeftoverMedications();

}
