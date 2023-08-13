package main.java;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import main.java.modul.NoteConsoleView;
import main.java.modul.NoteModelImpl;
import main.java.presenter.NotePresenterImpl;
import main.java.ui.NoteModel;
import main.java.ui.NotePresenter;
import main.java.ui.NoteView;


public class Main {
    public static void main(String[] args) {
        NoteModel model = new NoteModelImpl();
        NoteView view = new NoteConsoleView();
        NotePresenter presenter = new NotePresenterImpl(model, view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- MENU -----");
            System.out.println("1. Add Note");
            System.out.println("2. Display All Notes");
            System.out.println("3. Sort Notes");
            System.out.println("4. Filter Notes");
            System.out.println("5. Save Notes to File");
            System.out.println("6. Load Notes from File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // начало новой линии

            switch (choice) {
                case 1:
                    System.out.print("Enter datetime (yyyy-MM-dd HH:mm): ");
                    String datetime = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    presenter.addNote(datetime, description);
                    System.out.println("Note added successfully.");
                    break;
                case 2:
                    presenter.displayAllNotes();
                    break;
                case 3:
                    System.out.println("----- SORT OPTIONS -----");
                    System.out.println("1. Sort by Oldest to Newest");
                    System.out.println("2. Sort by Newest to Oldest");
                    System.out.print("Enter your choice: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine(); // начало новой линии
                    if (sortChoice == 1) {
                        presenter.sortNotesByOldestToNewest();
                    } else if (sortChoice == 2)
                    {
                        presenter.sortNotesByNewestToOldest();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    presenter.displayAllNotes();
                    break;
                case 4:
                    System.out.println("----- FILTER OPTIONS -----");
                    System.out.println("1. Filter by Day");
                    System.out.println("2. Filter by Week");
                    System.out.print("Enter your choice: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine(); // начало новой линии
                    if (filterChoice == 1) {
                        System.out.print("Enter day (yyyy-MM-dd): ");
                        String day = scanner.nextLine();
                        presenter.filterNotesByDay(day);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter week (yyyy-Www): ");
                        String week = scanner.nextLine();
                        presenter.filterNotesByWeek(week);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    System.out.print("Enter filename: ");
                    String saveFilename = scanner.nextLine();
                    presenter.saveNotesToFile(saveFilename);
                    System.out.println("Notes saved to file successfully.");
                    break;
                case 6:
                    System.out.print("Enter filename: ");
                    String loadFilename = scanner.nextLine();
                    presenter.loadNotesFromFile(loadFilename);
                    System.out.println("Notes loaded from file successfully.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
