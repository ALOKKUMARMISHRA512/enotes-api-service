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

    // 1. Save Note
    @Override
    public Boolean saveNotes(NotesDTO notesDto) {
        if (ObjectUtils.isEmpty(notesDto)) {
            throw new IllegalArgumentException("Notes data cannot be null");
        }

        Notes notes = modelMapper.map(notesDto, Notes.class);
        notesRepository.save(notes);
        return true;
    }

    // 2. Get All Notes
    @Override
    public List<NotesDTO> getAllNotes() {
        List<Notes> notesList = notesRepository.findAll();

        return notesList.stream()
                .map(note -> modelMapper.map(note, NotesDTO.class))
                .collect(Collectors.toList());
    }

    // 3. Get Note by ID
    @Override
    public NotesDTO getNoteById(Integer id) {
        Notes note = notesRepository.findById(id).orElse(null);

        if (note != null) {
            return modelMapper.map(note, NotesDTO.class);
        }
        return null;
    }

    // 4. Update Note by ID
    @Override
    public Boolean updateNoteById(Integer id, NotesDTO notesDto) {
        if (ObjectUtils.isEmpty(notesDto)) {
            throw new IllegalArgumentException("Notes data cannot be null");
        }

        Notes existingNote = notesRepository.findById(id).orElse(null);

        if (existingNote != null) {
            existingNote.setTitle(notesDto.getTitle());
            existingNote.setContent(notesDto.getContent());

            notesRepository.save(existingNote);
            return true;
        }
        return false;
    }

    // 5. Delete Note by ID
    @Override
    public Boolean deleteNoteById(Integer id) {
        Notes existingNote = notesRepository.findById(id).orElse(null);

        if (existingNote != null) {
            notesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
