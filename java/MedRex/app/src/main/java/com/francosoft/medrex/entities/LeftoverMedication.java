package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "leftover_medications")
public class LeftoverMedication {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int dose;
    private String status;
    private int medicationId;

    public LeftoverMedication(int dose, String status, int medicationId) {
        this.dose = dose;
        this.status = status;
        this.medicationId = medicationId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDose() {
        return dose;
    }

    public String getStatus() {
        return status;
    }

    public int getMedicationId() {
        return medicationId;
    }
}
