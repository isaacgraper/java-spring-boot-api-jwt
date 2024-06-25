package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleTypeDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.VehicleType;

public class VehicleTypeMapper {

    public static VehicleTypeDTO mapToVehicleTypeDTO(VehicleType vehicleType) {
        return new VehicleTypeDTO(
                vehicleType.getId(),
                vehicleType.getVehicleType()
        );
    }

    public static VehicleType mapToVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        return new VehicleType(
                vehicleTypeDTO.getId(),
                vehicleTypeDTO.getVehicleTypeModel()
        );
    }
}
