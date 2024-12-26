package com.enotes.validation;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;

@Component
public class validation {

	public void categoryValidation(CategoryDto categoryDto ) {
		
		if(ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("Category object/JSON should not be null or empty");
		}else {
			
			if(ObjectUtils.isEmpty(categoryDto.getName())) {
				throw new IllegalArgumentException("name fields is empty or null");
			}
		}
		
	}
	
}
