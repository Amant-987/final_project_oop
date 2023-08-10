package main.java;

import main.java.modul.AppointmentConsoleView;
import main.java.modul.AppointmentModelImpl;
import main.java.presenter.AppointmentPresenterImpl;
import main.java.ui.AppointmentModel;
import main.java.ui.AppointmentPresenter;
import main.java.ui.AppointmentView;

public class Main {
    public static void main(String[] args) {
        AppointmentModel model = new AppointmentModelImpl();
        AppointmentView view = new AppointmentConsoleView();
        AppointmentPresenter presenter = new AppointmentPresenterImpl(model, view);

        // Пример использования
        presenter.addAppointment("2022-10-10 14:00", "Meeting");
        presenter.addAppointment("2022-10-11 10:30", "Dentist Appointment");
        presenter.addAppointment("2022-10-12 16:00", "Gym");
//        presenter.displayAllAppointments();
//
//        // Сохранение и загрузка из файла
//        presenter.saveAppointmentsToFile("appointments.txt");
//        presenter.loadAppointmentsFromFile("appointments.txt");
//
//        // Отображение записей на конкретный день
//        presenter.displayAppointmentsForDay("2022-10-11");
//
//        // Отображение записей на конкретную неделю
//        presenter.displayAppointmentsForWeek("2022-10");
    }
}
