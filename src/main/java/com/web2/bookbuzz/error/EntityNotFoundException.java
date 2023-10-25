package com.web2.bookbuzz.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.web2.bookbuzz.dto.responses.ErrorResponseDTO;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }

    public ResponseEntity<?> getError(){
        return ResponseEntity.status(404).body(new ErrorResponseDTO(HttpStatus.NOT_FOUND, this.getMessage()));
    }
}
