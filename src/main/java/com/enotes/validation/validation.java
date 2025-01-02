package com.enotes.validation;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;
import com.enotes.exception.ValidationException;

@Component
public class validation {

	public void categoryValidation(CategoryDto categoryDto ) {
		
		Map< String, Object> error = new LinkedHashMap<>();
		
		if(ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("Category object/JSON should not be null or empty");
		}else {
			
			if(ObjectUtils.isEmpty(categoryDto.getName())) {
				error.put("name","name fields is empty or null");
			}else {
				if(categoryDto.getName().length() < 10) {
					error.put("name", "name length min < 10");
				}else if (categoryDto.getName().length() > 100) {
					error.put("name", "name length min > 10");
				}
			}
			

			if(ObjectUtils.isEmpty(categoryDto.getDescription())) {
				error.put("desc","Descrption fields is empty or null");
			}
			
			if(ObjectUtils.isEmpty(categoryDto.getIsActive())) {
				error.put("isactive", "IsActive fields is empty or null") ;
			}
			else {
				if(!categoryDto.getIsActive() == Boolean.TRUE || !categoryDto.getIsActive() == Boolean.FALSE) {
					error.put("isActiuve", "invaliude value isActive fields ");
				}
			}
		}
		
		

		
		if(!error.isEmpty()) {
			throw new ValidationException(error);
		}
		
	}
	
}
