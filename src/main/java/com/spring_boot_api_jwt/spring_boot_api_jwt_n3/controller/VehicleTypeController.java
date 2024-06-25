package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.controller;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleTypeDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-types")
public class VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @PostMapping
    public ResponseEntity<VehicleTypeDTO> createVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        VehicleTypeDTO savedVehicleType = vehicleTypeService.createVehicleType(vehicleTypeDTO);
        return new ResponseEntity<>(savedVehicleType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeDTO> getVehicleTypeById(@PathVariable("id") Long id) {
        VehicleTypeDTO vehicleTypeDTO = vehicleTypeService.getVehicleTypeById(id);
        return ResponseEntity.ok(vehicleTypeDTO);
    }

    @GetMapping
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes() {
        List<VehicleTypeDTO> vehicleTypeDTOs = vehicleTypeService.getAllVehiclesTypes();
        return ResponseEntity.ok(vehicleTypeDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleTypeDTO> updateVehicleType(@PathVariable("id") Long id,
                                                            @RequestBody VehicleTypeDTO vehicleTypeDTO) {
        VehicleTypeDTO updatedVehicleType = vehicleTypeService.updateVehicleType(id, vehicleTypeDTO);
        return ResponseEntity.ok(updatedVehicleType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleType(@PathVariable("id") Long id) {
        vehicleTypeService.deleteVehicleType(id);
        return ResponseEntity.ok("Vehicle type successfully deleted!");
    }
}
