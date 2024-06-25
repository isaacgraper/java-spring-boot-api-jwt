package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.Impl;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.VehicleTypeDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.VehicleType;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping.VehicleTypeMapper;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.VehicleTypeRepository;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.VehicleTypeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeServiceImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @PostConstruct
    public void insertInitialData() {
        if (vehicleTypeRepository.count() == 0) {
            VehicleType vehicleType1 = new VehicleType();
            vehicleType1.setVehicleType("Popular");

            VehicleType vehicleType2 = new VehicleType();
            vehicleType2.setVehicleType("Luxo");

            VehicleType vehicleType3 = new VehicleType();
            vehicleType3.setVehicleType("Super Luxo");

            vehicleTypeRepository.save(vehicleType1);
            vehicleTypeRepository.save(vehicleType2);
            vehicleTypeRepository.save(vehicleType3);
        }
    }

    @Override
    public VehicleTypeDTO createVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        VehicleType vehicleType = VehicleTypeMapper.mapToVehicleType(vehicleTypeDTO);
        VehicleType savedVehicleType = vehicleTypeRepository.save(vehicleType);
        return VehicleTypeMapper.mapToVehicleTypeDTO(savedVehicleType);
    }

    @Override
    public VehicleTypeDTO getVehicleTypeById(Long id) {
        VehicleType vehicleType = vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle type not found"));
        return VehicleTypeMapper.mapToVehicleTypeDTO(vehicleType);
    }

    @Override
    public List<VehicleTypeDTO> getAllVehiclesTypes() {
        List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll();
        return vehicleTypes.stream()
                .map(VehicleTypeMapper::mapToVehicleTypeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleTypeDTO updateVehicleType(Long id, VehicleTypeDTO vehicleTypeDTO) {
        VehicleType vehicleType = vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle type not found"));

        vehicleType.setVehicleType(vehicleTypeDTO.getVehicleTypeModel());

        VehicleType updatedVehicleType = vehicleTypeRepository.save(vehicleType);
        return VehicleTypeMapper.mapToVehicleTypeDTO(updatedVehicleType);
    }

    @Override
    public void deleteVehicleType(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
