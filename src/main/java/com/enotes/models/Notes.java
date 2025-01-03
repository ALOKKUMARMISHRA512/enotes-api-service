package com.enotes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter   
@Setter
public class Notes extends BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private String content; // Added this field
	
	@ManyToOne
//	@JoinColumn(name = "category_id") // Specifies the foreign key column
	private Category category;  // Fixed typo
	
}
