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
    private String cpf;
    private String email;
    private String password;
    private String phone;
}
