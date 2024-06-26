package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;

public class OwnerMapper {

    package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;

public class OwnerMapper {

    // Better logic to understand DTO to Entity and otherwise.
    //  public OwnerDTO toDto(Owner owner) {
    //     return new OwnerDTO(
    //         owner.getId(),
    //         owner.getCpf(),
    //         owner.getPassword(),
    //         owner.getFirstName(),
    //         owner.getPhone()
    //     );
    //   }
    
    //   public Owner toEntity(OwnerDTO ownerDTO) {
    //     return new Owner(
    //         ownerDTO.getId(),
    //         ownerDTO.getCpf(),
    //         ownerDTO.getPassword(),
    //         ownerDTO.getFirstName(),
    //         ownerDTO.getPhone()
    //     );
    //   }
    // }
    
    public static OwnerDTO mapToOwnerDTO(Owner owner) {
        return new OwnerDTO(
                owner.getId(),
                owner.getCpf(),
                owner.getEmail(),
                owner.getPassword(),
                owner.getPhone()
        );
    }
    public static Owner mapToOwner(OwnerDTO ownerDTO){
        return new Owner(
                ownerDTO.getId(),
                ownerDTO.getCpf(),
                ownerDTO.getEmail(),
                ownerDTO.getPassword(),
                ownerDTO.getPhone()
        );
    }
}
