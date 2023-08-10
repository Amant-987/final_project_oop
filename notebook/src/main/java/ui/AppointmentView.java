package main.java.ui;

import main.java.modul.Appointment;

import java.util.*;

// Интерфейс для представления
public interface AppointmentView {
    void displayAppointments(List<Appointment> appointments);
}