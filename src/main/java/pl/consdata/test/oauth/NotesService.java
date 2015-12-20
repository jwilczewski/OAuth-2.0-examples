package pl.consdata.test.oauth;

import java.util.List;

/**
 * Created by jwilczewski on 03.12.15.
 */
public interface NotesService {

    List<Note> getNotesIdsForUser(String user);

    Note getNote(String id);

    void setNotes(List<Note> notes);
}
