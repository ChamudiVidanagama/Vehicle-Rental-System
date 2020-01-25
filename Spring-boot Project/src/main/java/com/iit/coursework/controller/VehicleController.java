package com.iit.coursework.controller;

import com.iit.coursework.model.Vehicle;
import com.iit.coursework.repository.VehicleRepository;
import com.iit.coursework.service.CustomerService;
import com.iit.coursework.service.RentalVehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    public static List<Vehicle> vehicleList=new ArrayList<>();

    @Autowired
    RentalVehicleManager rentalVehicleManager;

    @Autowired
    CustomerService customerService;

    public static final int MAX_SLOTS = 50;

    public static String plateNo;

    public static String vehicleType;

    // request to add vehicles to database
    @RequestMapping(value = "/addVehicle")
    public String addVehicle() {
        rentalVehicleManager.addVehicleList(vehicleList);   // call to the WestminsterRentalVehicleManager service addVehicleList method
        rentalVehicleManager.printVehicleList(vehicleList);     // print list after adding new vehicle
        return "Vehicle has been successfully added" + "\n" + vehicleList;
    }

    // request to delete vehicles from database by plateNo
    @RequestMapping(value="/deleteVehicleFromId")
    public String deleteVehicle(){
        rentalVehicleManager.deleteVehicle(plateNo);    // call to the WestminsterRentalVehicleManager service deleteVehicle method
        return "Vehicle has been successfully deleted";
    }

    // request to print all the vehicles in vehicle list
    @RequestMapping(value="/printList")
    public String printList(){
        rentalVehicleManager.getAllVehicle();   // call to the vehicle WestminsterRentalVehicleManager getAllVehicle method
        return "Vehicle List has been successfully printed";
    }

    // request to generate report as a test file
    @RequestMapping(value="/generateVehicleReport")
    public String generateVehicleReport(){
        rentalVehicleManager.generateReport();  // call to the vehicle WestminsterRentalVehicleManager generateReport method
        return "Vehicle List has been generated in text file vehicleReport.txt";
    }

    // request to provide vehicle list to the UI
    @RequestMapping(value="/getVehicleList")
    public List<Vehicle> getVehicleList(){
        vehicleList = customerService.displayVehicleList();
        return vehicleList;
    }

    @RequestMapping(value="/getVehicleDetails")
    public Optional<Vehicle> getVehicleDetails(){
        Optional<Vehicle> vehicle = customerService.displayVehicleDetailsById();
        return vehicle;
    }
}
