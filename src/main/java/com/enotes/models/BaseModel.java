package com.enotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {



    @Column(name = "created_by",updatable = false)
    @CreatedBy 
    private Integer createdBy;

    @Column(name = "updated_by",insertable = false)
    @LastModifiedBy
    private Integer updatedBy;

    @Column(name = "created_date",updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updated_date",insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedDate;
    
    
    
}