package com.rider.companion.controller;

import com.rider.companion.dto.RideRequest;
import com.rider.companion.entity.RideEntity;
import com.rider.companion.service.RideService;
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
@RequestMapping("/api/rides")
@Tag(name = "Rides", description = "Operations for managing rides")
public class RideController {

  private final RideService rideService;

  public RideController(RideService rideService) {
    this.rideService = rideService;
  }

  @GetMapping
  @Operation(summary = "List rides", description = "Returns every ride.")
  @ApiResponses({@ApiResponse(responseCode = "200", description = "Rides returned")})
  public List<RideEntity> getAllRides() {
    return rideService.getAllRides();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a ride", description = "Returns one ride by its database identifier.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Ride returned"),
    @ApiResponse(responseCode = "404", description = "Ride not found")
  })
  public RideEntity getRideById(
      @Parameter(description = "Ride identifier", example = "1") @PathVariable Long id) {

    return rideService.getRideById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a ride")
  @ApiResponses({
    @ApiResponse(responseCode = "201", description = "Ride created"),
    @ApiResponse(responseCode = "400", description = "Invalid request body")
  })
  public RideEntity createRide(@Valid @RequestBody RideRequest ride) {

    return rideService.createRide(ride);
  }

  @PutMapping("/{id}")
  @Operation(
      summary = "Update a ride",
      description = "Replaces the editable fields of an existing ride.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Ride updated"),
    @ApiResponse(responseCode = "400", description = "Invalid request body"),
    @ApiResponse(responseCode = "404", description = "Ride not found")
  })
  public RideEntity updateRide(@PathVariable Long id, @Valid @RequestBody RideRequest ride) {

    return rideService.updateRide(id, ride);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete a ride")
  @ApiResponses({
    @ApiResponse(responseCode = "204", description = "Ride deleted"),
    @ApiResponse(responseCode = "404", description = "Ride not found")
  })
  public void deleteRide(@PathVariable Long id) {
    rideService.deleteRide(id);
  }
}
