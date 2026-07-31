package com.rider.companion.service;

import com.rider.companion.entity.RidersEntity;
import com.rider.companion.repository.RidersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RidersService {
    private final RidersRepository repository;

    public RidersService(RidersRepository repository) {
        this.repository = repository;
    }

    public List<RidersEntity> getAllRiders() {
        return repository.findAll();
    }

    public RidersEntity getRidersById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RiderNotFoundException(id));
    }

    public RidersEntity createRider(RidersEntity rider) {
        rider.setId(null);
        return repository.save(rider);
    }

    public RidersEntity updateRider(Long id, RidersEntity changes) {

        RidersEntity rider = getRidersById(id);

        rider.setUserId(changes.getUserId());
        rider.setLicenseType(changes.getLicenseType());
        rider.setLicenseYear(changes.getLicenseYear());
        rider.setExperienceLevel(changes.getExperienceLevel());
        rider.setPrimaryUsage(changes.getPrimaryUsage());
        rider.setEstimatedAnnualDistance(changes.getEstimatedAnnualDistance());

        return repository.save(rider);
    }


    public void deleteRider(Long id) {
        if (!repository.existsById(id)) {
            throw new RiderNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
