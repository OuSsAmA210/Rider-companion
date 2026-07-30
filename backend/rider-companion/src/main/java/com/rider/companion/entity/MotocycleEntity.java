package com.rider.companion.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "motorcycles")
@Schema(description = "A motorcycle stored in the rider's virtual garage")
@Getter
@Setter
@NoArgsConstructor
public class MotocycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(example = "Yamaha")
    @NotBlank(message = "Brand is required")
    private String brand;

    @Schema(example = "MT-07")
    @NotBlank(message = "Model is required")
    private String model;

    @Schema(example = "2024")
    @Min(value = 1885, message = "Year must be 1885 or later")
    @Column(name = "manufacture_year")
    private Integer year;
}
