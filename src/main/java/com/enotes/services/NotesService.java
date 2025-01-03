package com.enotes.services;

import java.util.List;

import com.enotes.dto.NotesDTO;

public interface NotesService {
	
	public Boolean saveNotes(NotesDTO notesDto);
	
	public List<NotesDTO> getAllNotes();
	

}
