package com.rider.companion.service;

public class RiderNotFoundException extends RuntimeException {

    public RiderNotFoundException(Long id) {
        super("Rider with id " + id + " not found");
    }
}