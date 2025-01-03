package com.enotes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.NotesDTO;
import com.enotes.models.Notes;
import com.enotes.repository.NotesRepository;



@Service
public class NotesServiceImpl implements NotesService {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public Boolean saveNotes(NotesDTO notesDto) {
		// Null check for input
		if (ObjectUtils.isEmpty(notesDto)) {
			throw new IllegalArgumentException("Notes data cannot be null");
		}

		// Map DTO to Entity
		Notes notes = modelMapper.map(notesDto, Notes.class);

		// Save entity
		notesRepository.save(notes);
		
		return true; // Indicating success
	}
	

	@Override
	public List<NotesDTO> getAllNotes() {
		// Fetch all notes and map them to DTO
		List<Notes> notesList = notesRepository.findAll();
		
		return notesList.stream()
		                .map(note -> modelMapper.map(note, NotesDTO.class))
		                .collect(Collectors.toList());
	}
}
