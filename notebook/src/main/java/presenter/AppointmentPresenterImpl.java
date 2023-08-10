package main.java.presenter;

import main.java.modul.Appointment;
import main.java.ui.AppointmentModel;
import main.java.ui.AppointmentPresenter;
import main.java.ui.AppointmentView;

import java.util.*;

// Реализация презентера
public class AppointmentPresenterImpl implements AppointmentPresenter {
    private AppointmentModel model;
    private AppointmentView view;

    public AppointmentPresenterImpl(AppointmentModel model, AppointmentView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addAppointment(String datetime, String description) {
        model.addAppointment(datetime, description);
    }

    @Override
    public void displayAllAppointments() {
        List<Appointment> appointments = model.getAppointments();
        view.displayAppointments(appointments);
    }

    @Override
    public void displayAppointmentsForDay(String day) {
        List<Appointment> appointments = model.getAppointmentsForDay(day);
        view.displayAppointments(appointments);
    }

    @Override
    public void displayAppointmentsForWeek(String week) {
        List<Appointment> appointments = model.getAppointmentsForWeek(week);
        view.displayAppointments(appointments);
    }

    @Override
    public void saveAppointmentsToFile(String filename) {
        model.saveAppointmentsToFile(filename);
    }

    @Override
    public void loadAppointmentsFromFile(String filename) {
        model.loadAppointmentsFromFile(filename);
    }
}
