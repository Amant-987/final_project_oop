package main.java.ui;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Интерфейс для презентера
public interface NotePresenter {
    void addNote(String datetime, String description);
    void displayAllNotes();
    void sortNotesByOldestToNewest();
    void sortNotesByNewestToOldest();
    void filterNotesByDay(String day);
    void filterNotesByWeek(String week);
    void saveNotesToFile(String filename);
    void loadNotesFromFile(String filename);
}
