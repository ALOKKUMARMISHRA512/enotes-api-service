package com.enotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.models.Category;
import com.enotes.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		
		category.setDeleted(false);
		
		Category saveCate = categoryRepository.save(category);
		
		if(ObjectUtils.isEmpty(saveCate)) {
			return false;
		}
		return true;
	}

	
	@Override
	public List<Category> getAllCategory(Category category) {
		// TODO Auto-generated method stub
		
		List<Category> list = categoryRepository.findAll();
		return list;
	}

	
	
}
