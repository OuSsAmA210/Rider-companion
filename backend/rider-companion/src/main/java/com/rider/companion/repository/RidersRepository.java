package com.rider.companion.repository;

import com.rider.companion.entity.RidersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidersRepository extends JpaRepository<RidersEntity, Long>{
}

