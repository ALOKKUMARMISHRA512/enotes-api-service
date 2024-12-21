package com.enotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BaseModel {

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_deleted")
    @JsonProperty("deleted")
    private boolean isDeleted;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}