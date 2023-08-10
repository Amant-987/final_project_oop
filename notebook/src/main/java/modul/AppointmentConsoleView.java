package main.java.modul;

import java.util.*;
import main.java.ui.AppointmentView;

// Реализация представления
public class AppointmentConsoleView implements AppointmentView {
    @Override
    public void displayAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment.getDatetime() + " - " + appointment.getDescription());
            }
        }
    }
}

