package com.iit.coursework.service;

import com.iit.coursework.model.Schedule;
import com.iit.coursework.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Vehicle> displayVehicleList();

    public Optional<Vehicle> displayVehicleDetailsById();

    public void saveBooking(Schedule schedule);
}
