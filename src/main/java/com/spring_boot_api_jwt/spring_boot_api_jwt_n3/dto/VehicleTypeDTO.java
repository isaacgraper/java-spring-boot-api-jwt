package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTypeDTO {
    private Long id;
    private String vehicleTypeModel;
}
