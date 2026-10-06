package kigali.clinic.rw.service;

import kigali.clinic.rw.domain.Appointment;
import kigali.clinic.rw.domain.AppointmentStatus;

import java.util.List;

public interface AppointmentService {
    String saveAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByStatus(AppointmentStatus status);
}
