package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.MedicineRefill;

import java.util.List;

@Dao
public interface MedicineRefillDao {

    @Insert
    void insert(MedicineRefill medicineRefill);

    @Update
    void update(MedicineRefill medicineRefill);

    @Delete
    void delete(MedicineRefill medicineRefill);

    @Query("DELETE FROM medicine_refills")
    void deleteAllMedicineRefills();

    @Query("SELECT * FROM medicine_refills")
    LiveData<List<MedicineRefill>> getAllMedicineRefills();
}
