package com.rider.companion.controller;

import com.rider.companion.entity.RidersEntity;
import com.rider.companion.service.RidersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/riders")
@Tag(name = "Riders", description = "Operations for adding riders")
public class RidersController {
    private final RidersService ridersService;

    public RidersController(RidersService ridersService) {
        this.ridersService = ridersService;
    }
    @GetMapping
    @Operation(summary = "List riders", description = "Returns every rider .")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Riders returned")
    })
    public List<RidersEntity> getAllRiders() {
        return ridersService.getAllRiders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a rider", description = "Returns one rider by its database identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rider returned"),
            @ApiResponse(responseCode = "404", description = "Rider not found")
    })
    public RidersEntity getRidersById(
            @Parameter(description = "Motorcycle identifier", example = "1") @PathVariable Long id) {
        return ridersService.getRidersById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a rider")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Rider created"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    public RidersEntity createRider(@Valid @RequestBody RidersEntity rider) {
        return ridersService.createRider(rider);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a rider", description = "Replaces the editable fields of an existing rider.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rider updated"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Rider not found")
    })
    public RidersEntity updateRider(@PathVariable Long id, @Valid @RequestBody RidersEntity rider) {
        return ridersService.updateRider(id, rider);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a rider")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Rider deleted"),
            @ApiResponse(responseCode = "404", description = "Rider not found")
    })
    public void deleteRider(@PathVariable Long id) {
        ridersService.deleteRider(id);
    }
}