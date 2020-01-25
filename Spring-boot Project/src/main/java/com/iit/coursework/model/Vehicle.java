package com.iit.coursework.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Comparator;

public class Vehicle {
    @Id
    private String plateNo;
    private String make;
    private String model;
    private BigDecimal rate;
    private String transmission;
    private int engineCapacity;
    private int noOfPassengers;
    private String vehicleType;
    private String vehicleImage;

    // constructors
    public Vehicle(String plateNo, String make, String model, BigDecimal rate, String transmission, int engineCapacity, int noOfPassengers,String vehicleType){
        this.plateNo = plateNo;
        this.make = make;
        this.model = model;
        this.rate = rate;
        this.transmission = transmission;
        this.engineCapacity = engineCapacity;
        this.noOfPassengers = noOfPassengers;
        this.vehicleType = vehicleType;
    }

    // getter and setters
    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleType() { return vehicleType;  }

    public void setVehicleType(String vehicleType) {  this.vehicleType = vehicleType;  }

    // to string method
    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", rate=" + rate +
                ", transmission='" + transmission + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", noOfPassengers=" + noOfPassengers +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

    // Comparator to sort by vehicle make
    public static Comparator<Vehicle> vehicleComparator = new Comparator<Vehicle>() {

        public int compare(Vehicle v1, Vehicle v2) {
            String vehicleMake1 = v1.getMake().toLowerCase();
            String vehicleMake2 = v2.getMake().toLowerCase();

            //alphabetical order
            return vehicleMake1.compareTo(vehicleMake2);

        }};
}
