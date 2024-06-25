package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.Impl;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.exception.InvalidCredentialsException;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.exception.ResourceNotFoundException;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping.OwnerMapper;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository.OwnerRepository;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.String;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final long CPF_LENGTH = 11;
    private final int PWD_LENGTH = 4;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {

        // validate cpf length
        if (ownerDTO.getCpf().length() != CPF_LENGTH) throw new InvalidCredentialsException("CPF must have 13 digits.");

        // validate pwd length
        if(String.valueOf(ownerDTO.getPassword()).length() != PWD_LENGTH) throw new InvalidCredentialsException("Password must have 4 digits.");

        Owner owner = OwnerMapper.mapToOwner(ownerDTO);
        Owner savedOwner = ownerRepository.save(owner);

        return OwnerMapper.mapToOwnerDTO(savedOwner);
    }

    @Override
    public OwnerDTO getOwnerByCpf(String cpf) {

        Owner owner = ownerRepository.findByCpf(cpf)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner with CPF not found: " + cpf));
       
        return OwnerMapper.mapToOwnerDTO(owner);
    }

    @Override
    public List<OwnerDTO> getAllOwners() {

        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(OwnerMapper::mapToOwnerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO updateOwner(String cpf, OwnerDTO ownerDTO) {

        Owner owner = ownerRepository.findByCpf(cpf).orElseThrow(
                () -> new ResourceNotFoundException("Owner with given CPF does not exist: " + cpf)
        );

        // validate cpf length
        if (ownerDTO.getCpf().toString().length() != CPF_LENGTH) throw new InvalidCredentialsException("CPF must have 1 digits.");

        // validate pwd length
        if(String.valueOf(ownerDTO.getPwd()).length() != PWD_LENGTH) throw new InvalidCredentialsException("Password must have 4 digits.");

        owner.setCpf(ownerDTO.getCpf());
        owner.setEmail(ownerDTO.getEmail());
        owner.setPassword(ownerDTO.getPassword());
        owner.setPhone(ownerDTO.getPhone());

        Owner updatedOwner = ownerRepository.save(owner);

        return OwnerMapper.mapToOwnerDTO(updatedOwner);
    }

    @Override
    public void deleteOwner(String cpf) {

        Owner owner = ownerRepository.findByCpf(cpf).orElseThrow(
                () -> new ResourceNotFoundException("Owner with given CPF does not exist: " + cpf)
        );

        ownerRepository.deleteByCpf(cpf);
    }
}
