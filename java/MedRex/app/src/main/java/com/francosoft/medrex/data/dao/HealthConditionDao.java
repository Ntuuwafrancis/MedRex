package com.francosoft.medrex.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.francosoft.medrex.entities.HealthCondition;

import java.util.List;

@Dao
public interface HealthConditionDao {

    @Insert
    void insert(HealthCondition healthCondition);

    @Update
    void update(HealthCondition healthCondition);

    @Delete
    void delete(HealthCondition healthCondition);

    @Query("DELETE FROM health_conditions")
    void deleteAllHealthConditions();

    @Query("SELECT * FROM health_conditions")
    LiveData<List<HealthCondition>> getAllHealthConditions();
}
