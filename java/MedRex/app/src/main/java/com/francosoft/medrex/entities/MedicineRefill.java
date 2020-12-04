package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicine_refills")
public class MedicineRefill {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int quantity;
    private String date;
    private int medicineId;

    public MedicineRefill(int quantity, String date, int medicineId) {
        this.quantity = quantity;
        this.date = date;
        this.medicineId = medicineId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public int getMedicineId() {
        return medicineId;
    }
}
