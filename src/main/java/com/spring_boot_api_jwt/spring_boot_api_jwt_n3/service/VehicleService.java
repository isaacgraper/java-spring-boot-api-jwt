package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    // Vehicle
    // create vehicle
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    // get vehicle by plate
    VehicleDTO getVehicleByPlate(String plate);

    // get all vehicles
    List<VehicleDTO> getAllVehicles();

    // update vehicle
    VehicleDTO updateVehicle(String plate, VehicleDTO VehicleDTO);

    // delete vehicle by plate (logic implemented in repository)
    // void deleteVehicle(String plate); 
}
