
package com.web2.bookbuzz.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.web2.bookbuzz.dto.responses.ErrorResponseDTO;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedEntityException extends RuntimeException {
    public DuplicatedEntityException(String message) {
        super(message);
    }

    public ResponseEntity<?> getError() {
        return ResponseEntity.status(409).body(new ErrorResponseDTO(HttpStatus.CONFLICT, this.getMessage()));
    }
}
