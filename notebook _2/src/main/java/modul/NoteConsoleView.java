package main.java.modul;

import main.java.ui.NoteView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


// Реализация представления
public class NoteConsoleView implements NoteView {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("----- Notes -----");
        for (Note note : notes) {
            String datetime = note.getDatetime();
            String description = note.getDescription();
            System.out.println("Datetime: " + datetime + ", Description: " + description);
        }
    }
}