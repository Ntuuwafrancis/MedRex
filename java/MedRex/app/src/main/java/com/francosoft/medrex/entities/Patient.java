package com.francosoft.medrex.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patient")
public class Patient {

    @PrimaryKey
    @NonNull
    private String username;

    private String firstName;
    private String lastName;
    private String contact;
    private String address;
    private String email;

    public Patient(String username, String firstName, String lastName, String contact, String address, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
