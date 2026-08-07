package com.rider.companion.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Schema(description = "A registered user of the Rider Companion platform")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;

  @Schema(example = "Oussama")
  @NotBlank(message = "First name is required")
  private String firstName;

  @Schema(example = "Bouhastine")
  @NotBlank(message = "Last name is required")
  private String lastName;

  @Schema(example = "oussama@example.com")
  @Email(message = "Email must be valid")
  private String email;

  @Schema(example = "$2a$10$abc123hashedpassword")
  @NotBlank(message = "Password hash is required")
  private String passwordHash;

  @Schema(example = "2026-08-01")
  private LocalDate createdAt;

  @Schema(example = "2026-08-01")
  private LocalDate updatedAt;
}
