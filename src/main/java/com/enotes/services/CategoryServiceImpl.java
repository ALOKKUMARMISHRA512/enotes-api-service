
package com.enotes.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;
import com.enotes.dto.CategoryResponseDto;
import com.enotes.models.Category;
import com.enotes.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired 
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {
        // Null check for input
        if (ObjectUtils.isEmpty(categoryDto)) {
            throw new IllegalArgumentException("Category data cannot be null");
        }

        Category category;

        // Check if ID is present for Update
        if (categoryDto.getId() != null) {
            // Find existing category
            category = categoryRepository.findById(categoryDto.getId())
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryDto.getId()));

            // Update existing category
            category.setUpdatedDate(LocalDateTime.now());
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            category.setIsActive(categoryDto.getIsActive() != null ? categoryDto.getIsActive() : true);
        } else {
            // Create new category
            category = modelMapper.map(categoryDto, Category.class);
            category.setCreatedDate(LocalDateTime.now());
            category.setIsActive(categoryDto.getIsActive() != null ? categoryDto.getIsActive() : true);
        }

        // Save the category (insert or update)
        categoryRepository.save(category);
        return true;
    }


    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAllActiveCategories() {
        return categoryRepository.findByIsActiveTrueAndIsDeletedFalse();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    @Transactional
    @Override
    public boolean deleteCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setDeleted(true);
            categoryRepository.save(category);
            return true;
        } else {
            return false;
        }
    }
}