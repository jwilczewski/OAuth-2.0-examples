package pl.consdata.test.oauth;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by jwilczewski on 03.12.15.
 */
@Controller
public class NotesController {

    private NotesService notesService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/notes/{noteId}")
    public ResponseEntity<String> getNote(@PathVariable("noteId") String noteId) throws IOException {
        Note note = notesService.getNote(noteId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<String>(objectMapper.writeValueAsString(note), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/notes")
    public ResponseEntity<String> getNotes(Principal principal) throws IOException {
        List<Note> notes = notesService.getNotesIdsForUser(principal.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<String>(objectMapper.writeValueAsString(notes), headers, HttpStatus.OK);
    }

    public void setNotesService(NotesService notesService) {
        this.notesService = notesService;
    }
}
