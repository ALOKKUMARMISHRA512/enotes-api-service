package com.enotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enotes.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}