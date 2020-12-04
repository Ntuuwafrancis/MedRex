package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prescriptions")
public class Prescription {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int fullDose;
    private int morning;
    private int afternoon;
    private int evening;
    private String date;
    private String status;
    private String recommendations;
    private int healthConditionId;
    private int medicineId;

    public Prescription(int fullDose, int morning, int afternoon, int evening, String date, String status, String recommendations, int healthConditionId, int medicineId) {
        this.fullDose = fullDose;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.date = date;
        this.status = status;
        this.recommendations = recommendations;
        this.healthConditionId = healthConditionId;
        this.medicineId = medicineId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getFullDose() {
        return fullDose;
    }

    public int getMorning() {
        return morning;
    }

    public int getAfternoon() {
        return afternoon;
    }

    public int getEvening() {
        return evening;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public int getHealthConditionId() {
        return healthConditionId;
    }

    public int getMedicineId() {
        return medicineId;
    }
}
