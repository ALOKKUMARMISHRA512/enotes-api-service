package com.enotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.enotes.dto.NotesDTO;
import com.enotes.services.NotesService;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@Validated
public class NotesController {

    @Autowired
    private NotesService notesService;

    // 1. Create Note (Save)
    @PostMapping("/save")
    public ResponseEntity<String> saveNotes(@RequestBody NotesDTO notesDto) {
        try {
            Boolean isSaved = notesService.saveNotes(notesDto);

            if (isSaved) {
                return new ResponseEntity<>("Note saved successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to save note!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. Get All Notes
    @GetMapping("/all")
    public ResponseEntity<List<NotesDTO>> getAllNotes() {
        try {
            List<NotesDTO> notesList = notesService.getAllNotes();

            if (notesList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(notesList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 3. Get Note by ID
    @GetMapping("/{id}")
    public ResponseEntity<NotesDTO> getNoteById(@PathVariable Integer id) {
        try {
            NotesDTO note = notesService.getNoteById(id);

            if (note != null) {
                return new ResponseEntity<>(note, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 4. Update Note by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNote(@PathVariable Integer id, @RequestBody NotesDTO notesDto) {
        try {
            Boolean isUpdated = notesService.updateNoteById(id, notesDto);

            if (isUpdated) {
                return new ResponseEntity<>("Note updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update note!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 5. Delete Note by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Integer id) {
        try {
            Boolean isDeleted = notesService.deleteNoteById(id);

            if (isDeleted) {
                return new ResponseEntity<>("Note deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to delete note!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
