package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String email;
    private String contact;
    private String specialty;
    private int healthCenterId;

    public Doctor(String name, String contact, String specialty) {
        this.name = name;
        this.contact = contact;
        this.specialty = specialty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHealthCenterId(int healthCenterId) {
        this.healthCenterId = healthCenterId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getHealthCenterId() {
        return healthCenterId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
