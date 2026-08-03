package com.rider.companion.service;

import com.rider.companion.entity.RideEntity;
import com.rider.companion.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository repository;

    public RideService(RideRepository repository) {
        this.repository = repository;
    }

    public List<RideEntity> getAllRides() {
        return repository.findAll();
    }

    public RideEntity getRideById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RideNotFoundException(id));
    }

    public RideEntity createRide(RideEntity ride) {
        ride.setId(null);
        return repository.save(ride);
    }

    public RideEntity updateRide(Long id, RideEntity changes) {

        RideEntity ride = getRideById(id);

        ride.setUserId(changes.getUserId());
        ride.setMotorcycleId(changes.getMotorcycleId());
        ride.setTitle(changes.getTitle());

        ride.setPlannedDate(changes.getPlannedDate());
        ride.setDepartureTime(changes.getDepartureTime());

        ride.setDepartureLocation(changes.getDepartureLocation());
        ride.setDestination(changes.getDestination());

        ride.setEstimatedDistance(changes.getEstimatedDistance());
        ride.setActualDistance(changes.getActualDistance());

        ride.setEstimatedDuration(changes.getEstimatedDuration());
        ride.setActualDuration(changes.getActualDuration());

        ride.setRideType(changes.getRideType());

        ride.setUseHighway(changes.getUseHighway());
        ride.setUseTolls(changes.getUseTolls());

        ride.setPlannedBreaks(changes.getPlannedBreaks());

        ride.setFuelCost(changes.getFuelCost());

        ride.setStatus(changes.getStatus());

        ride.setRating(changes.getRating());

        ride.setNotes(changes.getNotes());

        ride.setCreatedAt(changes.getCreatedAt());
        ride.setUpdatedAt(changes.getUpdatedAt());

        return repository.save(ride);
    }

    public void deleteRide(Long id) {

        if (!repository.existsById(id)) {
            throw new RideNotFoundException(id);
        }

        repository.deleteById(id);
    }
}