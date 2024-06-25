package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {
    private Long id;
    private Long cpf;
    private String password;
    private String firstName;
    private String phone;
}
