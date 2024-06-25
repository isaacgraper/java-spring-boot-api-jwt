package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
