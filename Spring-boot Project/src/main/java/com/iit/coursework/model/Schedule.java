package com.iit.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("schedule")
public class Schedule {
        @Id
        private int scheduleId;
        private String pickupLocation;
        private String dropoffLocation;
        private Date pickupDate;
        private Date dropoffDate;
        private String plateNo;
        private String vehicleType;

    // constructor
    public Schedule(int scheduleId, String pickupLocation, String dropoffLocation, Date pickupDate, Date dropoffDate, String plateNo, String vehicleType) {
        this.scheduleId = scheduleId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.plateNo = plateNo;
        this.vehicleType = vehicleType;
    }

    // getters and setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // toString method
    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropoffLocation='" + dropoffLocation + '\'' +
                ", pickupDate='" + pickupDate + '\'' +
                ", dropoffDate='" + dropoffDate + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
