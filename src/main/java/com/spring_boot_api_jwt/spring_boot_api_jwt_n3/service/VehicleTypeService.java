package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleTypeDTO;

import java.util.List;

public interface VehicleTypeService {

    // Vehicle Type
    // create vehicle type
    VehicleTypeDTO createVehicleType(VehicleTypeDTO vehicleTypeDTO);

    // get vehicle type by id
    VehicleTypeDTO getVehicleTypeById(Long id);

    // get all vehicles types
    List<VehicleTypeDTO> getAllVehiclesTypes();

    // update vehicle type
    VehicleTypeDTO updateVehicleType(Long id, VehicleTypeDTO VehicleTypeDTO);

    // delete vehicle type
    void deleteVehicleType(Long id);
}
