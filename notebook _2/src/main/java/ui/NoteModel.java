package main.java.ui;

import main.java.modul.Note;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Интерфейс для модели
public interface NoteModel {
    void addNote(String datetime, String description);
    List<Note> getNotes();
    List<Note> getNotesForDay(String day);
    List<Note> getNotesForWeek(String week);
    void sortNotesByOldestToNewest();
    void sortNotesByNewestToOldest();
    void saveNotesToFile(String filename);
    void loadNotesFromFile(String filename);
}