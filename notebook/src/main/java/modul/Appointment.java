package main.java.modul;

// Модель данных для записи
public class Appointment {
    private String datetime;
    private String description;

    public Appointment(String datetime, String description) {
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
