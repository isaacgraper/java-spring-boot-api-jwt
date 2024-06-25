package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.Impl;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Vehicle;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.exception.ResourceNotFoundException;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping.VehicleMapper;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.OwnerRepository;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.VehicleRepository;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
       
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        
        return VehicleMapper.mapToVehicleDTO(savedVehicle);
    }

    @Override
    public VehicleDTO getVehicleByPlate(String plate) {

        Vehicle vehicle = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + plate));
        
        return VehicleMapper.mapToVehicleDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {

        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(VehicleMapper::mapToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicle(String plate, VehicleDTO vehicleDTO) {
       
       Vehicle vehicle = vehicleRepository.findByPlate(plate).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle not found with id: " + plate));

        vehicle.setPlate(vehicleDTO.getPlate());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setOwnerId(vehicleDTO.getOwnerId());
        vehicle.setVehicleTypeId(vehicleDTO.getVehicleTypeId());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return VehicleMapper.mapToVehicleDTO(updatedVehicle);
    }

    @Override
    public void deleteVehicle(String plate) {

        Vehicle vehicle = vehicleRepository.findByPlate(plate).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle not found with id: " + plate));

        vehicleRepository.deleteByPlate(vehicle);
    }
}
