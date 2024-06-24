package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.controller;

import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.dto.OwnerDTO;
import com.spring_boot_api_jwt.spring_boot_api_jwt_n3.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    // service injection
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // add owner
    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO){
        OwnerDTO savedOwner = ownerService.createOwner(ownerDTO);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }

    // get owner by CPF
    @GetMapping("{cpf}")
    public ResponseEntity<OwnerDTO> getOwnerByCPF(@PathVariable("cpf") Long cpf) {
        OwnerDTO ownerDTO = ownerService.getOwnerByCpf(cpf);
        return ResponseEntity.ok(ownerDTO);
    }

    // get all owners
    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getAllOwners(){
        List<OwnerDTO> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    // update owner
    @PutMapping("{cpf}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable("cpf") Long cpf,
                                                @RequestBody OwnerDTO updateOwner) {
        OwnerDTO ownerDTO = ownerService.updateOwner(cpf, updateOwner);
        return ResponseEntity.ok(ownerDTO);
    }

    // delete owner by CPF
    @DeleteMapping("{cpf}")
    public  ResponseEntity<String> deleteOwner(@PathVariable("cpf") Long cpf) {
        ownerService.deleteOwner(cpf);
        return ResponseEntity.ok("Owner successfully deleted!");
    }
}
