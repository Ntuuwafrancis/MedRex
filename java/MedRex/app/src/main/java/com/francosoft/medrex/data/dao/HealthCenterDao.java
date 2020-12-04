package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.HealthCenter;

import java.util.List;

@Dao
public interface HealthCenterDao {

    @Insert
    void insert(HealthCenter healthCenter);

    @Update
    void update(HealthCenter healthCenter);

    @Delete
    void delete(HealthCenter healthCenter);

    @Query("DELETE FROM health_centers")
    void deleteAllHealthCenters();

    @Query("SELECT * FROM health_centers")
    LiveData<List<HealthCenter>> getAllHealthCenters();
}
