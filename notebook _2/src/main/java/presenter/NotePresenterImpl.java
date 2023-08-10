package main.java.presenter;

import main.java.modul.Note;
import main.java.ui.NoteModel;
import main.java.ui.NotePresenter;
import main.java.ui.NoteView;

import java.util.*;

public class NotePresenterImpl implements NotePresenter {
    private NoteModel model;
    private NoteView view;

    public NotePresenterImpl(NoteModel model, NoteView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addNote(String datetime, String description) {
        model.addNote(datetime, description);
    }

    @Override
    public void displayAllNotes() {
        view.displayNotes(model.getNotes());
    }

    @Override
    public void sortNotesByOldestToNewest() {
        model.sortNotesByOldestToNewest();
    }

    @Override
    public void sortNotesByNewestToOldest() {
        model.sortNotesByNewestToOldest();
    }

    @Override
    public void filterNotesByDay(String day) {
        view.displayNotes(model.getNotesForDay(day));
    }

    @Override
    public void filterNotesByWeek(String week) {
        view.displayNotes(model.getNotesForWeek(week));
    }

    @Override
    public void saveNotesToFile(String filename) {
        model.saveNotesToFile(filename);
    }

    @Override
    public void loadNotesFromFile(String filename) {
        model.loadNotesFromFile(filename);
    }
}