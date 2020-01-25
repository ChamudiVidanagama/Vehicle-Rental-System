package com.iit.coursework.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iit.coursework.model.Vehicle;
import com.iit.coursework.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("rentalVehicleManager")
public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    @Autowired
    VehicleRepository vehicleRepository;

    List<Vehicle> vehicleList=new ArrayList<>();
    public static final int MAX_SLOTS = 50;
    public long usedSlots;

    // this method is to test object
    @Override
    public String getVehicle(String plateNo) {
        Optional<Vehicle> vehicle= vehicleRepository.findById(plateNo);
        return  vehicle.get().getMake()+" " +vehicle.get().getModel();
    }

    // add vehicle list to the database
    @Override
    public String addVehicleList(List<Vehicle> vehicleList) {
        String message;
        usedSlots = vehicleList.size();
        usedSlots = usedSlots + vehicleRepository.count();
        System.out.println("Used slots : "+usedSlots);
        if (usedSlots < MAX_SLOTS) {
            vehicleRepository.saveAll(vehicleList);
            message ="Successfully Added";
        }else{
            message = "NO SLOTS AVAILABLE";
            System.out.println(message);
        }
        return message;
    }

    // delete vehicle from database by plateNo
    @Override
    public String deleteVehicle(String plateNo) {
        usedSlots = 0;
        usedSlots = vehicleRepository.count();
        usedSlots = usedSlots - 1;
        System.out.println("Used Slots : "+usedSlots);
        vehicleRepository.deleteById(plateNo);

        System.out.println("Available Slots : "+ (MAX_SLOTS - usedSlots));
        return plateNo +" successfully deleted";
    }

    // print available list of vehicles
    @Override
    public void printVehicleList(List<Vehicle> vehicleList) {
        //System.out.println(vehicleList);

        ObjectMapper mapper = new ObjectMapper();

        Collections.sort(vehicleList, Vehicle.vehicleComparator);    // sort using vehicleComparator

        for(Vehicle vehicle: vehicleList){

            try {
                String vehicleObj = mapper.writeValueAsString(vehicle);
                System.out.println("Vehicle List = " + vehicleObj);
                //System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    // print all vehicles in JSON format by retrieving from the database
    @Override
    public void getAllVehicle() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList= vehicleRepository.findAll();

        Collections.sort(vehicleList, Vehicle.vehicleComparator);   // sort using vehicleComparator

        ObjectMapper mapper = new ObjectMapper();
        for(Vehicle vehicle: vehicleList){
            try {
                String allVehicles = mapper.writeValueAsString(vehicle);
                System.out.println("All Vehicles = " + allVehicles);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    // generate vehicle report in a text file
    @Override
    public void generateReport() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList = vehicleRepository.findAll();   

        // creating unique textfile everytime using date formator
        String filepath = "C:\\Users\\User\\Downloads\\SpringBootMongo-master\\SpringBootMongo-master\\vehicleReport";
        String extention = ".txt";
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String filename = filepath + df.format(new Date()) + "." + extention;

        File file = new File(filename);
        try(FileWriter fileWriter = new FileWriter(file,true)){
            try(PrintWriter pw = new PrintWriter(fileWriter,true)){
                for(Vehicle vehicle : vehicleList){
                    pw.println(String.format(vehicle.getPlateNo() + " : " + vehicle.getMake() + " : "  + vehicle.getModel() + " : " + vehicle.getRate() + " : " + vehicle.getTransmission() + " : " + vehicle.getEngineCapacity() + " : " + vehicle.getNoOfPassengers() + " : " + vehicle.getVehicleType() + " : "));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}



