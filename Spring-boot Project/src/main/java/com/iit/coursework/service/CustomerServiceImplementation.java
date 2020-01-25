package com.iit.coursework.service;

import com.iit.coursework.model.Schedule;
import com.iit.coursework.model.Vehicle;
import com.iit.coursework.repository.ScheduleRepository;
import com.iit.coursework.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("customerService")
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    List<Vehicle> vehicleList=new ArrayList<>();

    public static String plateNo;

    @Override
    public List<Vehicle> displayVehicleList() {
        vehicleList = vehicleRepository.findAll();
        return vehicleList;
    }

    @Override
    public Optional<Vehicle> displayVehicleDetailsById(){
        Optional<Vehicle> vehicle = vehicleRepository.findById(plateNo);
        return vehicle;
    }

    @Override
    public void saveBooking(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
