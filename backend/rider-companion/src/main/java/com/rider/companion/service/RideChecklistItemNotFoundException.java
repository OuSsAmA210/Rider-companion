package com.rider.companion.service;

public class RideChecklistItemNotFoundException extends RuntimeException {

    public RideChecklistItemNotFoundException(Long id) {
        super("Ride checklist item with id " + id + " not found");
    }
}