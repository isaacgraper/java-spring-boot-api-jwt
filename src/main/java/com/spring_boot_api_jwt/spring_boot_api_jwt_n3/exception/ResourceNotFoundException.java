package com.spring_boot_api_jwt.spring_boot_api_jwt_n3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    // owner or any resource not found
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
