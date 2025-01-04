package com.enotes.services;

import java.util.List;
import com.enotes.dto.NotesDTO;

public interface NotesService {

    // CRUD Operations
    public Boolean saveNotes(NotesDTO notesDto);

    public List<NotesDTO> getAllNotes();

    public NotesDTO getNoteById(Integer id);

    public Boolean updateNoteById(Integer id, NotesDTO notesDto);

    public Boolean deleteNoteById(Integer id);
}
