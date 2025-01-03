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

    // Save Notes
    @PostMapping("/save")
    public ResponseEntity<String> saveNotes(@RequestBody NotesDTO notesDto) {
        try {
            Boolean isSaved = notesService.saveNotes(notesDto);

            if (isSaved) {
                return new ResponseEntity<>("Notes saved successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to save notes!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Notes
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
}
