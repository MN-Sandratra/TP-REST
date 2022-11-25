package com.example.Hotel.model.hotel;

import java.util.*;

public class GPS {

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
}