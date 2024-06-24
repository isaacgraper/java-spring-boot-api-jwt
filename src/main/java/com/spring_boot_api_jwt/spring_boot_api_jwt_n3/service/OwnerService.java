package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;

import java.util.List;

public interface OwnerService {

    // Owner
    // create owner
    OwnerDTO createOwner(OwnerDTO ownerDTO);

    // get owner by CPF
    OwnerDTO getOwnerByCpf(Long cpf);

    // get all owners
    List<OwnerDTO> getAllOwners();

    OwnerDTO updateOwner(Long cpf, OwnerDTO ownerDTO);

    void deleteOwner(Long cpf);
}
