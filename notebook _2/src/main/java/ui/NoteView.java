package main.java.ui;

import main.java.modul.Note;

import java.util.*;

// Интерфейс для представления
public interface NoteView {
    void displayNotes(List<Note> notes);
}