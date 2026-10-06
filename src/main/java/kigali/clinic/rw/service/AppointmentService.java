package kigali.clinic.rw.service;

import kigali.clinic.rw.domain.Appointment;
import kigali.clinic.rw.domain.AppointmentStatus;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    String saveAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByStatus(AppointmentStatus status);
    List<Appointment> getAppointmentsBetween(LocalDate start, LocalDate end);

    List<Object[]> countAppointmentsByStatus();
}
