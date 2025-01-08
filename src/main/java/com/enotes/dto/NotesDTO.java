package com.enotes.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// NotesDTO class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesDTO {
	
    private Integer id;

    // Title cannot be blank
    @NotBlank(message = "Title cannot be blank")
    private String title;

    // Content cannot be blank
    @NotBlank(message = "Content cannot be blank")
    private String content; // Added this field

    // Description cannot be blank
    @NotBlank(message = "Description cannot be blank")
    private String description;

    // Category cannot be null
    @NotNull(message = "Category is required")
    private CategoryDto category;

    private Integer createdBy;

    private Integer updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate; 
    
    // Inner DTO class for category
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryDto {
    	
    	private Long id;

        @NotBlank(message = "Category name cannot be blank")
        private String name;
    }

}
