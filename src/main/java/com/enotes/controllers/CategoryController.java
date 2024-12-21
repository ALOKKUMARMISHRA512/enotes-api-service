package com.enotes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.enotes.dto.CategoryDto;
import com.enotes.models.Category;
import com.enotes.services.CategoryService;
import com.enotes.dto.CategoryResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<CategoryResponseDto> saveCategory(@RequestBody @Valid CategoryDto categoryDto) {
        try {
            Boolean isSaved = categoryService.saveCategory(categoryDto);
            if (isSaved) {
                return new ResponseEntity<>(new CategoryResponseDto("Category saved successfully", categoryDto), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(new CategoryResponseDto("Failed to save category", null), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new CategoryResponseDto(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-category")
    public ResponseEntity<CategoryResponseDto> getCategory(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "id") String sortBy,
                                                           @RequestParam(defaultValue = "asc") String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sortBy)));
        Page<Category> categories = categoryService.getAllCategory(pageRequest);
        return new ResponseEntity<>(new CategoryResponseDto("Fetched categories successfully", categories), HttpStatus.OK);
    }

    @GetMapping("/get-active-categories")
    public ResponseEntity<CategoryResponseDto> getActiveCategories() {
        List<Category> activeCategories = categoryService.getAllActiveCategories();
        return new ResponseEntity<>(new CategoryResponseDto("Fetched active categories successfully", activeCategories), HttpStatus.OK);
    }
    
    @GetMapping("/get-category-byId/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    	Category categoryResponseDto = categoryService.getCategoryById(id);
        if (categoryResponseDto != null) {
            return ResponseEntity.ok(categoryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
