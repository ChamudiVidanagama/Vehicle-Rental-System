package com.iit.coursework.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("car")
public class Car extends Vehicle {

    private String typeOfCar;
    private boolean isAirConditioned;

    // constructor
    public Car(String plateNo, String make, String model, BigDecimal rate, String transmission, int engineCapacity, int noOfPassengers, String vehicleType, String typeOfCar, boolean isAirConditioned) {
        super(plateNo, make, model, rate, transmission, engineCapacity, noOfPassengers, vehicleType);
        this.typeOfCar = typeOfCar;
        this.isAirConditioned = isAirConditioned;
    }

    // getters and setters
    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        isAirConditioned = airConditioned;
    }

    // toString method
    @Override
    public String toString() {
        return "Car{" +
                "plateNo='" + getPlateNo() + '\'' +
                ", make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", rate=" + getRate() + '\'' +
                ", transmission='" + getTransmission() + '\'' +
                ", engineCapacity=" + getEngineCapacity() + '\'' +
                ", noOfPassengers=" + getNoOfPassengers() + '\'' +
                ", vehicleType=" + getVehicleType() + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", isAirConditioned=" + isAirConditioned + '\'' +
                '}';
    }
}

