package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String plate;
    private String model;
    private BigDecimal price;
    private Owner ownerId;
    private VehicleType vehicleTypeId;
}
