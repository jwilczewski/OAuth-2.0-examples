package pl.consdata.test.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.consdata.test.oauth.Note;
import pl.consdata.test.oauth.NotesController;
import pl.consdata.test.oauth.NotesService;
import pl.consdata.test.oauth.NotesServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwilczewski on 04.12.15.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public NotesController notesController(NotesService notesService) {
        NotesController notesController = new NotesController();
        notesController.setNotesService(notesService);
        return notesController;
    }

    @Bean NotesService notesService() {
        NotesService notesService = new NotesServiceImpl();
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("1", "zdenek", "title1", "Note 1 content"));
        notes.add(new Note("2", "zdenek", "title2", "Note 2 content"));
        notesService.setNotes(notes);
        return notesService;
    }
}
