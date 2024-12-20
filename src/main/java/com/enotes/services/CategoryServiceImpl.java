package com.enotes.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;
import com.enotes.models.Category;
import com.enotes.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

        if (ObjectUtils.isEmpty(categoryDto)) {
            return false;
        }

        Category category = new Category();
        category.setActive(true);
        category.setCreatedBy(categoryDto.getCreatedBy());
        category.setCreatedDate(LocalDateTime.now());
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());

        Category saveCategory = categoryRepository.save(category);

        return !ObjectUtils.isEmpty(saveCategory);
    }

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
