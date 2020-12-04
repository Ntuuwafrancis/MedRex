package com.francosoft.medrex.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicine")
public class Medicine {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String genericName;
    private String productName;
    private int quantity;
    private String units;
    private String healthCondition;
    private String sideEffects;

    public Medicine(String productName, int quantity, String units, String healthCondition, String sideEffects, String genericName) {
        this.genericName = genericName;
        this.productName = productName;
        this.quantity = quantity;
        this.units = units;
        this.healthCondition = healthCondition;
        this.sideEffects = sideEffects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getGenericName() {
        return genericName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnits() {
        return units;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public String getSideEffects() {
        return sideEffects;
    }
}
