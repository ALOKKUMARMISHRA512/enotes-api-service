package com.enotes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enotes.models.Category;



public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> getAllCategory(Category category);


}
