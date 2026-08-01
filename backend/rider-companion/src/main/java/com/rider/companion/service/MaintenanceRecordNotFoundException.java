package com.rider.companion.service;

public class MaintenanceRecordNotFoundException
        extends RuntimeException {

  public MaintenanceRecordNotFoundException(Long id) {
    super("Maintenance record with id " + id + " not found");
  }
}