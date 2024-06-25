package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;

public class OwnerMapper {

    package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.mapping;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;

public class OwnerMapper {

    // forma simplificada e melhor, porém requer mudança na estrutura do projeto
    //  public OwnerDTO toDto(Owner owner) {
    //     return new OwnerDTO(
    //         owner.getId(),
    //         owner.getCpf(),
    //         owner.getPassword(), // remover o pwd por password, mudar entidade e dto
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
                owner.getPwd(),
                owner.getFirstName(),
                owner.getPhone()
        );
    }
    public static Owner mapToOwner(OwnerDTO ownerDTO){
        return new Owner(
                ownerDTO.getId(),
                ownerDTO.getCpf(),
                ownerDTO.getPwd(),
                ownerDTO.getFirstName(),
                ownerDTO.getPhone()
        );
    }
}
