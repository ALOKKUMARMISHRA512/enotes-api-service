package com.enotes.dto;

import java.time.LocalDateTime;

import com.enotes.models.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesDTO {
	
	private Integer id;
	
	private String title;
	
	private String description;
	
	private Category category;

    private Integer createdBy;

    private Integer updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate; 

}
