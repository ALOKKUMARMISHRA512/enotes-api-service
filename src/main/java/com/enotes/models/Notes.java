package com.enotes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notes") // Explicit table name
@AllArgsConstructor
@NoArgsConstructor
@Getter   
@Setter
public class Notes extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @Column(length = 500)
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Lob // Large Object for storing long text
    @NotBlank(message = "Content cannot be blank")
    private String content; // Added this field

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) // Better fetch type and cascade
    @JoinColumn(name = "category_id", nullable = false) // Specifies the foreign key column
    private Category category;
}
