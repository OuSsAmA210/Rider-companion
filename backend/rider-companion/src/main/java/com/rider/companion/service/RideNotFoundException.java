package com.rider.companion.service;

public class RideNotFoundException extends RuntimeException {

    public RideNotFoundException(Long id) {
        super("Ride with id " + id + " not found");
    }
}