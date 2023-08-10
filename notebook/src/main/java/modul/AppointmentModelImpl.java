package main.java.modul;


import main.java.ui.AppointmentModel;

import java.io.*;
import java.util.*;

// Реализация модели
public class AppointmentModelImpl implements AppointmentModel {
    private List<Appointment> appointments;

    public AppointmentModelImpl() {
        appointments = new ArrayList<>();
    }

    @Override
    public void addAppointment(String datetime, String description) {
        Appointment appointment = new Appointment(datetime, description);
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsForDay(String day) {
        // Реализация поиска записей на конкретный день
        List<Appointment> appointmentsForDay = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDatetime().startsWith(day)) {
                appointmentsForDay.add(appointment);
            }
        }
        return appointmentsForDay;
    }

    @Override
    public List<Appointment> getAppointmentsForWeek(String month) {
        // Реализация поиска записей на конкретную неделю
        List<Appointment> appointmentsForMonth = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDatetime().startsWith(month)) {
                appointmentsForMonth.add(appointment);
            }
        }
        return appointmentsForMonth;
    }

    @Override
    public void saveAppointmentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Appointment appointment : appointments) {
                writer.println(appointment.getDatetime() + "," + appointment.getDescription());
            }
        } catch (IOException e) {
            System.out.println("Error while saving appointments to file: " + e.getMessage());
        }
    }

    @Override
    public void loadAppointmentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            appointments.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String datetime = data[0];
                String description = data[1];
                Appointment appointment = new Appointment(datetime, description);
                appointments.add(appointment);
            }
        } catch (IOException e) {
            System.out.println("Error while loading appointments from file: " + e.getMessage());
        }
    }
}