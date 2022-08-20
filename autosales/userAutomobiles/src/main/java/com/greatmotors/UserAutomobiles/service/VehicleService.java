package com.greatmotors.UserAutomobiles.service;

import com.greatmotors.UserAutomobiles.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> findAllVehicles();
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(String modelName);

}



