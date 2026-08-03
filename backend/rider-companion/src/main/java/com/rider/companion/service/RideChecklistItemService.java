package com.rider.companion.service;

import com.rider.companion.entity.RideChecklistItemEntity;
import com.rider.companion.repository.RideChecklistItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideChecklistItemService {

    private final RideChecklistItemRepository repository;

    public RideChecklistItemService(
            RideChecklistItemRepository repository) {
        this.repository = repository;
    }

    public List<RideChecklistItemEntity> getAllRideChecklistItems() {
        return repository.findAll();
    }

    public RideChecklistItemEntity getRideChecklistItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RideChecklistItemNotFoundException(id));
    }

    public RideChecklistItemEntity createRideChecklistItem(
            RideChecklistItemEntity item) {

        item.setId(null);
        return repository.save(item);
    }

    public RideChecklistItemEntity updateRideChecklistItem(
            Long id,
            RideChecklistItemEntity changes) {

        RideChecklistItemEntity item =
                getRideChecklistItemById(id);

        item.setRideId(changes.getRideId());
        item.setLabel(changes.getLabel());
        item.setChecked(changes.getChecked());

        return repository.save(item);
    }

    public void deleteRideChecklistItem(Long id) {

        if (!repository.existsById(id)) {
            throw new RideChecklistItemNotFoundException(id);
        }

        repository.deleteById(id);
    }
}