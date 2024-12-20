package com.enotes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public class BaseModel {

    private boolean isActive;

    private boolean isDeleted;

    private Integer createdBy;

    private Integer updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
