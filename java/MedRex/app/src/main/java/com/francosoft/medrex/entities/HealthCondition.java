package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "health_conditions")
public class HealthCondition {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String condition;
    private String areaAffected;
    private String diagnosisDate;
    private String status;
    private String endDate;
    private int healthCenterId;
    private int doctorId;

    public HealthCondition(String condition, String areaAffected, String diagnosisDate, String status) {
        this.condition = condition;
        this.areaAffected = areaAffected;
        this.diagnosisDate = diagnosisDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getHealthCenterId() {
        return healthCenterId;
    }

    public void setHealthCenterId(int healthCenterId) {
        this.healthCenterId = healthCenterId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getCondition() {
        return condition;
    }

    public String getAreaAffected() {
        return areaAffected;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public String getStatus() {
        return status;
    }
}
