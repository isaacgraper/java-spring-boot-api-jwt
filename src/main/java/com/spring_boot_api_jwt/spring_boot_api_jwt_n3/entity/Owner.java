package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password", nulable = false)
    private String password;
    
    @Column(name = "phone", nullable = true)
    private String phone;
}
