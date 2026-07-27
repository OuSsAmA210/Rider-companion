package com.rider.companion.repository;

import com.rider.companion.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepo extends JpaRepository<Motorcycle, Long> {

}