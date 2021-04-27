package com.com.uber;

import java.math.BigDecimal;
import java.sql.Date;

public class UberTest {
/*
    */
/*
    1. Multi-floor parking lot system
    2. Bikes and Cars
    3. Parking spots
    4. Billing mechanism
    5. Get any parking slot number
     *//*


    class ParkingLot{
        ParkingSpace parkingSpace;
        Customer customer;
        Vehicle vehicle;
    }

    class ParkingSpace{
        long parkingId;
        int floorNo;
        int parkingEntranceDist;
        int parkingExitDist;
        ParkingSpot parkingSpot;
        BigDecimal cost;
        boolean isVacant;
    }

    enum ParkingSpot{
        small,
        big
    }

    class Customer{
        int entry;
        String vehicleNumber;
        Date entryTime;
        Date exitTime;
        Vehicle vehicle;
        ParkingSpace parkingSpace;

        public Customer(String vehicleNumber, Date entryTime, Date exitTime, Vehicle vehicle, ParkingSpace parkingSpace) {
            this.vehicleNumber = vehicleNumber;
            this.entryTime = entryTime;
            this.exitTime = exitTime;
            this.vehicle = vehicle;
            this.parkingSpace = parkingSpace;
        }
    }

    enum Vehicle{
        bike,
        car
    }

    interface Admin{
        void addCustomerEntry(Customer customer);
        // -> invoked by addCustomerEntry -> ParkingSpace getNearestParkingSpot(ParkingSpace parkingSpace, ParkingSpot parkingSpot);
        BigDecimal checkCostAtExit(String vehicleNumber, Date exitTime);
    }

    public class AdminImpl implements Admin{
        public void addCustomerEntry(Customer customer){
            //service -> repo -> save;
            // invoke getNearestParkingSpot;
        }

        ParkingSpace getNearestParkingSpot(Customer customer){
            ParkingSpace parkingSpace = service -> repo.findVacantParkingSpaces(customer.entry, customer.vehicle);
            return parkingSpace;
        }

        public BigDecimal checkCostAtExit(String vehicleNumber, Date exitTime){
            Customer customer = service - >repo -> findById(String vehicleNumber);
            customer.exitTime(exitTime);
            service -> repo -> update
            BigDecimal costAtCheckout = (customer.exitTime - customer.entry) * customer.parkingSpace.cost;
            return costAtCheckout;
        }
    }
*/
}
