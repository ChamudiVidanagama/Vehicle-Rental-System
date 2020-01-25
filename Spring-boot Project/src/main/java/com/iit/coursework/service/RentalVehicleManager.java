package com.iit.coursework.service;

import com.iit.coursework.model.Vehicle;

import java.util.List;

public interface RentalVehicleManager {

    public String getVehicle(String plateNo);

    public String addVehicleList (List<Vehicle> vehicle);

    public String deleteVehicle(String plateNo);

    public void printVehicleList(List<Vehicle> vehicleList);

    public void getAllVehicle();

    public void generateReport();
}
