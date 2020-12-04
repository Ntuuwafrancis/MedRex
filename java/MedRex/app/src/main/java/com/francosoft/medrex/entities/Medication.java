package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medications")
public class Medication {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int dose;
    private String time;
    private String date;
    private String status;
    private String effects;
    private int prescriptionId;
    private int medicineId;

    public Medication(String status, int prescriptionId) {
        this.status = status;
        this.prescriptionId = prescriptionId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public int getId() {
        return id;
    }

    public int getDose() {
        return dose;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getEffects() {
        return effects;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }
}

