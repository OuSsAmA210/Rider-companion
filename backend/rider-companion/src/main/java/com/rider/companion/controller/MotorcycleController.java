package com.rider.companion.controller;

import com.rider.companion.entity.Motorcycle;
import com.rider.companion.service.MotorcycleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService service;

    public MotorcycleController(MotorcycleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Motorcycle> getAllMotorcycles() {
        return service.getAllMotorcycles();
    }
}