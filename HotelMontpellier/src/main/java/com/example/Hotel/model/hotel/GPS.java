package com.example.Hotel.model.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

public class GPS {
    private int id;
    private double lattitude;

    private double longitude;

    private double z;

    public GPS(double lattitude, double longitude, double z) {
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.z = z;
    }

    @Override
    public String toString() {
        return "GPS : [" + lattitude + ", " + longitude + ", " + z + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}