package pl.consdata.test.oauth;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jwilczewski on 03.12.15.
 */
public class NotesServiceImpl implements NotesService {

    private List<Note> notes;

    @Override
    public List<Note> getNotesIdsForUser(String user) {
        return notes.stream().filter(note -> note.getUserId().equals(user)).collect(Collectors.toList());
    }

    @Override
    public Note getNote(String id) {
        return notes.stream().filter(note ->  note.getId().equals(id)).findFirst().get();
    }

    @Override
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
