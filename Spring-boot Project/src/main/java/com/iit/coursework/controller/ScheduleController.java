package com.iit.coursework.controller;

import com.iit.coursework.model.Schedule;
import com.iit.coursework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ScheduleController {

    @Autowired
    CustomerService customerService;

    // post method to get form data from the booking form in GUI
    @PostMapping(value = "/saveBooking", consumes = "application/json", produces = "application/json")
    public String saveVehicleBooking(@RequestBody Schedule schedule) {
        customerService.saveBooking(schedule);
        return "Booking has been successfully saved";
    }
}
