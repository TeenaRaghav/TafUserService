package com.User.service.TafUserService.DTO;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    public void createdPrePersist() {
        this.created_at = LocalDateTime.now();// Set created_at when the entity is first persisted
        this.updated_at = LocalDateTime.now();// Set updated_at as well to the same value initially
    }
    @PreUpdate
    public void preUpdate() {
        this.updated_at = LocalDateTime.now();  // Update updated_at whenever the entity is updated
    }
}
