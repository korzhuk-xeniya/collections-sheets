package com.skypro.collections_sheets.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeStoragelsFullException extends RuntimeException{
    public EmployeeStoragelsFullException(String message) {
        super(message);
    }
}
