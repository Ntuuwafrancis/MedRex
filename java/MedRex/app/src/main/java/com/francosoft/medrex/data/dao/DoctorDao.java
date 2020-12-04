package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.Doctor;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    void insert(Doctor doctor);

    @Update
    void update(Doctor doctor);

    @Delete
    void delete(Doctor doctor);

    @Query("DELETE FROM doctors")
    void deleteAllDoctors();

    @Query("SELECT * FROM doctors")
    LiveData<List<Doctor>> getAllDoctors();
}
