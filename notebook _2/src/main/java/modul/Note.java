package main.java.modul;

// Модель данных для записи
public class Note {
    private String datetime;
    private String description;

    public Note(String datetime, String description) {
        this.datetime = datetime;
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getDescription() {
        return description;
    }
}