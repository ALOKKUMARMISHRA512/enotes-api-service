package com.enotes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private Boolean isActive ; 
    
    private Boolean isDeleted;


    private Integer createdBy;

    private Integer updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
