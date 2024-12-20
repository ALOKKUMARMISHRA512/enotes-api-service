package com.enotes.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
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
    
    @Autowired 
    private ModelMapper modelmaper;

    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

        if (ObjectUtils.isEmpty(categoryDto)) {
            return false;
        }
 
        Category category = modelmaper.map(categoryDto,Category.class);
        
        Category saveCategory = categoryRepository.save(category);

        return !ObjectUtils.isEmpty(saveCategory);
    }

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
