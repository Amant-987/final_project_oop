package main.java.ui;

// Интерфейс для презентера
public interface AppointmentPresenter {
    void addAppointment(String datetime, String description);
    void displayAllAppointments();
    void displayAppointmentsForDay(String day);
    void displayAppointmentsForWeek(String week);
    void saveAppointmentsToFile(String filename);
    void loadAppointmentsFromFile(String filename);
}
