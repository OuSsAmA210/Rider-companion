package com.rider.companion.service;

import com.rider.companion.entity.MotocycleEntity;
import com.rider.companion.repository.MotorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

    private final MotorcycleRepository repository;

    public MotorcycleService(MotorcycleRepository repository) {
        this.repository = repository;
    }

    public List<MotocycleEntity> getAllMotorcycles() {
        return repository.findAll();
    }

    public MotocycleEntity getMotorcycleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MotorcycleNotFoundException(id));
    }

    public MotocycleEntity createMotorcycle(MotocycleEntity motorcycle) {
        motorcycle.setId(null);
        return repository.save(motorcycle);
    }

    public MotocycleEntity updateMotorcycle(Long id, MotocycleEntity changes) {
        MotocycleEntity motorcycle = getMotorcycleById(id);
        motorcycle.setBrand(changes.getBrand());
        motorcycle.setModel(changes.getModel());
        motorcycle.setYear(changes.getYear());
        return repository.save(motorcycle);
    }

    public void deleteMotorcycle(Long id) {
        if (!repository.existsById(id)) {
            throw new MotorcycleNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
