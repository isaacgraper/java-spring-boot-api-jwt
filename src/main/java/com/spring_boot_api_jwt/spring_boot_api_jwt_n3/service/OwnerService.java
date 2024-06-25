package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import java.lang.String;

import java.util.List;

public interface OwnerService {

    // Owner
    // create owner
    OwnerDTO createOwner(OwnerDTO ownerDTO);

    // get owner by CPF
    OwnerDTO getOwnerByCpf(String cpf);

    // get all owners
    List<OwnerDTO> getAllOwners();

    // update owner by CPF
    OwnerDTO updateOwner(String cpf, OwnerDTO ownerDTO);

    // delete owner by CPF
    void deleteOwner(String cpf);
}
