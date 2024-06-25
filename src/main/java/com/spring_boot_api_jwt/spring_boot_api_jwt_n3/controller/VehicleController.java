package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.controller;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.exception.ResourceNotFoundException;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO createdVehicle = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<VehicleDTO> getVehicleByPlate(@PathVariable String plate) {
        VehicleDTO vehicle = vehicleService.getVehicleByPlate(plate);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PutMapping("/{plate}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable String plate, @RequestBody VehicleDTO vehicleDTO) {
        try {
            VehicleDTO updatedVehicle = vehicleService.updateVehicle(plate, vehicleDTO);
            return ResponseEntity.ok(updatedVehicle);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String plate) {
        vehicleService.deleteVehicle(plate);
        return ResponseEntity.ok("Vehicle successfully deleted!");
    }
}
