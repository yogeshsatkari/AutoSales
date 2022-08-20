package com.greatmotors.UserAutomobiles.controller;

import com.greatmotors.UserAutomobiles.model.Vehicle;
import com.greatmotors.UserAutomobiles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    // http://localhost:8086/auto/all/               [get]
    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    // http://localhost:8086/auto/add/                [post]
    @PostMapping("/add")
    public ResponseEntity<Vehicle> addProduct(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle),HttpStatus.CREATED);
    }

    // http://localhost:8086/auto/update/               [put]
    @PutMapping("/update")
    public ResponseEntity<Vehicle> updateProduct(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle),HttpStatus.OK);
    }

    // http://localhost:8086/auto/delete/{modelName}                [delete]
    @DeleteMapping("/delete/{modelName}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String modelName) {
        vehicleService.deleteVehicle(modelName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
