package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate", nullable = false)
    private String plate;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;

}
