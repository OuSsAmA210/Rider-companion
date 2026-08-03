package com.rider.companion.repository;

import com.rider.companion.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository
        extends JpaRepository<RideEntity, Long> {
}