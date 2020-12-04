package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.Medicine;

import java.util.List;

@Dao
public interface MedicineDao {

    @Insert
    void insert(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Query("DELETE FROM medicine")
    void deleteAllMedicine();

    @Query("SELECT * FROM medicine")
    LiveData<List<Medicine>> getAllMedicine();
}
