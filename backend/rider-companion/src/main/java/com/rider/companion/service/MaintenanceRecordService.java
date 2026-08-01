package com.rider.companion.service;

import com.rider.companion.entity.MaintenanceRecordEntity;
import com.rider.companion.repository.MaintenanceRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceRecordService {

    private final MaintenanceRecordRepository repository;

    public MaintenanceRecordService(
            MaintenanceRecordRepository repository) {
        this.repository = repository;
    }

    public List<MaintenanceRecordEntity> getAllMaintenanceRecords() {
        return repository.findAll();
    }

    public MaintenanceRecordEntity getMaintenanceRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new MaintenanceRecordNotFoundException(id));
    }

    public MaintenanceRecordEntity createMaintenanceRecord(
            MaintenanceRecordEntity maintenanceRecord) {

        maintenanceRecord.setId(null);

        return repository.save(maintenanceRecord);
    }

    public MaintenanceRecordEntity updateMaintenanceRecord(
            Long id,
            MaintenanceRecordEntity changes) {

        MaintenanceRecordEntity maintenanceRecord =
                getMaintenanceRecordById(id);

        maintenanceRecord.setMotorcycleId(
                changes.getMotorcycleId());

        maintenanceRecord.setMaintenanceType(
                changes.getMaintenanceType());

        maintenanceRecord.setStatus(
                changes.getStatus());

        maintenanceRecord.setCompletionDate(
                changes.getCompletionDate());

        maintenanceRecord.setPlannedDate(
                changes.getPlannedDate());

        maintenanceRecord.setMileage(
                changes.getMileage());

        maintenanceRecord.setPlannedMileage(
                changes.getPlannedMileage());

        maintenanceRecord.setCost(
                changes.getCost());

        maintenanceRecord.setServiceProvider(
                changes.getServiceProvider());

        maintenanceRecord.setNotes(
                changes.getNotes());

        maintenanceRecord.setCreatedAt(
                changes.getCreatedAt());

        maintenanceRecord.setUpdatedAt(
                changes.getUpdatedAt());

        return repository.save(maintenanceRecord);
    }

    public void deleteMaintenanceRecord(Long id) {

        if (!repository.existsById(id)) {
            throw new MaintenanceRecordNotFoundException(id);
        }

        repository.deleteById(id);
    }
}