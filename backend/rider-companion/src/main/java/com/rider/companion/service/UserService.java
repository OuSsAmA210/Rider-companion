package com.rider.companion.service;

import com.rider.companion.entity.UserEntity;
import com.rider.companion.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(id));
    }

    public UserEntity createUser(UserEntity user) {
        user.setId(null);
        return repository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity changes) {

        UserEntity user = getUserById(id);

        user.setFirstName(changes.getFirstName());
        user.setLastName(changes.getLastName());
        user.setEmail(changes.getEmail());
        user.setPasswordHash(changes.getPasswordHash());
        user.setCreatedAt(changes.getCreatedAt());
        user.setUpdatedAt(changes.getUpdatedAt());

        return repository.save(user);
    }

    public void deleteUser(Long id) {

        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        repository.deleteById(id);
    }
}