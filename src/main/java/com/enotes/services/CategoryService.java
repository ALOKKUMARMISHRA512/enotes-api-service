package com.enotes.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.enotes.dto.CategoryDto;
import com.enotes.dto.CategoryResponseDto;
import com.enotes.models.Category;

public interface CategoryService {

    Boolean saveCategory(CategoryDto categoryDto);

    Page<Category> getAllCategory(Pageable pageable);

    List<Category> getAllActiveCategories();

    Category getCategoryById(Long id);
    
	
}
