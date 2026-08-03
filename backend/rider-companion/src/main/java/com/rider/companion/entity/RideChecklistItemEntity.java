package com.rider.companion.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ride_checklist_items")
@Schema(description = "A checklist item associated with a ride")
@Getter
@Setter
@NoArgsConstructor
public class RideChecklistItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(example = "1")
    private Long rideId;

    @Schema(example = "Check tire pressure")
    private String label;

    @Schema(example = "true")
    private Boolean checked;
}