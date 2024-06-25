package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Vehicle;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.VehicleType;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.OwnerRepository;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.VehicleTypeRepository;

public class VehicleMapper {

    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getPlate(),
                vehicle.getModel(),
                vehicle.getPrice(),
                vehicle.getOwnerId(),
                vehicle.getVehicleTypeId()
        );
    }

    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        return new Vehicle(
                vehicleDTO.getId(),
                vehicleDTO.getPlate(),
                vehicleDTO.getModel(),
                vehicleDTO.getPrice(),
                vehicleDTO.getOwnerId(),
                vehicleDTO.getVehicleTypeId()
        );
    }
}
