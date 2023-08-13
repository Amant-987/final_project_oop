package main.java.modul;


import main.java.ui.NoteModel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Реализация модели
public class NoteModelImpl implements NoteModel {
    private List<Note> notes = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private SimpleDateFormat weekFormat = new SimpleDateFormat("yyyy-'W'ww");

    public Date parseDate(String datetime) {
        try {
            return dateFormat.parse(datetime);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void addNote(String datetime, String description) {
        notes.add(new Note(datetime, description));
    }

    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public List<Note> getNotesForDay(String day) {
        List<Note> notesForDay = new ArrayList<>();
        for (Note note : notes) {
            String noteDate = note.getDatetime().split(" ")[0];
            if (noteDate.equals(day)) {
                notesForDay.add(note);
            }
        }
        return notesForDay;
    }

    @Override
    public List<Note> getNotesForWeek(String week) {
        List<Note> notesForWeek = new ArrayList<>();
        for (Note note : notes) {
            String noteWeek = weekFormat.format(parseDate(note.getDatetime()));
            if (noteWeek.equals(week)) {
                notesForWeek.add(note);
            }
        }
        return notesForWeek;
    }

    @Override
    public void sortNotesByOldestToNewest() {
        notes.sort((a, b) -> a.getDatetime().compareTo(b.getDatetime()));
    }

    @Override
    public void sortNotesByNewestToOldest() {
//        notes.sort(Comparator.comparing(this::parseDate).reversed());
        notes.sort((b, a) -> a.getDatetime().compareTo(b.getDatetime()));
    }

    @Override
    public void saveNotesToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Note note : notes) {
                String noteWeek = weekFormat.format(parseDate(note.getDatetime()));
                writer.println(note.getDatetime() + ";" + note.getDescription() + ";" + noteWeek);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadNotesFromFile(String filename) {
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String datetime = parts[0];
                    String description = parts[1];
                    notes.add(new Note(datetime, description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}