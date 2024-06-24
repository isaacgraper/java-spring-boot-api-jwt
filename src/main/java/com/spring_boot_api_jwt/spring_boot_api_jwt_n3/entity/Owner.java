package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "cpf", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "password", nullable = false)
    private int pwd;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "phone")
    private String phone;
}
