package com.rider.companion.repository;

import com.rider.companion.entity.MaintenanceRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecordEntity, Long> {}
