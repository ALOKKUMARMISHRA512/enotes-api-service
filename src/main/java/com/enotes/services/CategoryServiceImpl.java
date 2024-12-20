package com.enotes.services;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;
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
        if (ObjectUtils.isEmpty(categoryDto)) {
            return false;
        }

        // Set default value for isActive if not provided
        if (!categoryDto.isActive()) {
            categoryDto.setActive(true);
        }
        
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setCreatedDate(LocalDateTime.now());
        category.setUpdatedDate(LocalDateTime.now());

        Category savedCategory = categoryRepository.save(category);
        return !ObjectUtils.isEmpty(savedCategory);
    }


    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAllActiveCategories() {
        return categoryRepository.findByIsActiveTrue();
    }
}
