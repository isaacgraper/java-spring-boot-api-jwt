package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.repository;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByCpf(Long cpf);
}
