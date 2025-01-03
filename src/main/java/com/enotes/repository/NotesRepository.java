package com.enotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

	
}
