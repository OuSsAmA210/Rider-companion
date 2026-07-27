package com.rider.companion.service;

import com.rider.companion.entity.Motorcycle;
import com.rider.companion.repository.MotorcycleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

    private final MotorcycleRepo repository;

    public MotorcycleService(MotorcycleRepo repository) {
        this.repository = repository;
    }

    public List<Motorcycle> getAllMotorcycles() {
        return repository.findAll();
    }
}