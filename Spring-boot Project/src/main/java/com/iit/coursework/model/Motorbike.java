package com.iit.coursework.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("motorbike")
public class Motorbike extends Vehicle {
    private String bikeType;
    private boolean isClutchBike;

    // constructor
    public Motorbike(String plateNo, String make, String model, BigDecimal rate, String transmission, int engineCapacity, int noOfPassengers, String vehicleType, String bikeType, boolean isClutchBike) {
        super(plateNo, make, model, rate, transmission, engineCapacity, noOfPassengers, vehicleType);
        this.bikeType = bikeType;
        this.isClutchBike = isClutchBike;
    }

    // getters and setters
    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public boolean isClutchBike() {
        return isClutchBike;
    }

    public void setClutchBike(boolean clutchBike) {
        isClutchBike = clutchBike;
    }

    // toString method
    @Override
    public String toString() {
        return "Motorbike{" +
                "plateNo='" + getPlateNo() + '\'' +
                ", make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", rate=" + getRate() + '\'' +
                ", transmission='" + getTransmission() + '\'' +
                ", engineCapacity=" + getEngineCapacity() + '\'' +
                ", noOfPassengers=" + getNoOfPassengers() + '\'' +
                ", vehicleType=" + getVehicleType() + '\'' +
                ", bikeType='" + bikeType + '\'' +
                ", isClutchBike=" + isClutchBike +
                '}';
    }

}
