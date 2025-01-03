package com.enotes.services;

import java.util.List;
import com.enotes.dto.NotesDTO;

public interface NotesService {

    // CRUD Operations
    Boolean saveNotes(NotesDTO notesDto);

    List<NotesDTO> getAllNotes();

    NotesDTO getNoteById(Integer id);

    Boolean updateNoteById(Integer id, NotesDTO notesDto);

    Boolean deleteNoteById(Integer id);
}
