package com.rider.companion.controller;

import com.rider.companion.service.MotorcycleNotFoundException;
import com.rider.companion.service.RiderNotFoundException;
import com.rider.companion.service.MaintenanceRecordNotFoundException;
import com.rider.companion.service.UserNotFoundException;
import com.rider.companion.service.RideNotFoundException;
import com.rider.companion.service.RideChecklistItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MotorcycleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(MotorcycleNotFoundException exception) {
        return Map.of("message", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidation(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Invalid request body");
        return Map.of("message", message);
    }

    @ExceptionHandler(RiderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleRiderNotFound(
            RiderNotFoundException exception
    ) {
        return Map.of("message", exception.getMessage());
    }
    @ExceptionHandler(MaintenanceRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleMaintenanceRecordNotFound(
            MaintenanceRecordNotFoundException exception) {

        return Map.of("message", exception.getMessage()
        );
    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleUserNotFound(
            UserNotFoundException exception) {

        return Map.of(
                "message",
                exception.getMessage()
        );
    }
    @ExceptionHandler(RideNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleRideNotFound(
            RideNotFoundException exception) {

        return Map.of(
                "message",
                exception.getMessage()
        );
    }
    @ExceptionHandler(RideChecklistItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleRideChecklistItemNotFound(
            RideChecklistItemNotFoundException exception) {

        return Map.of(
                "message",
                exception.getMessage()
        );
    }
}
