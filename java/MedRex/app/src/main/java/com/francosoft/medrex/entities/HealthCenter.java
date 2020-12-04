package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "health_centers")
public class HealthCenter {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String contact;
    private String address;

    public HealthCenter(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }
}
