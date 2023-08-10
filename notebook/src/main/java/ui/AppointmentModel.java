package main.java.ui;

import main.java.modul.Appointment;

import java.util.*;

// Интерфейс для модели
public interface AppointmentModel {
    void addAppointment(String datetime, String description);
    List<Appointment> getAppointments();
    List<Appointment> getAppointmentsForDay(String day);
    List<Appointment> getAppointmentsForWeek(String week);
    void saveAppointmentsToFile(String filename);
    void loadAppointmentsFromFile(String filename);
}
