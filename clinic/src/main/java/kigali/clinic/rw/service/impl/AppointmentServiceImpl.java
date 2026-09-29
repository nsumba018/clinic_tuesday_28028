package kigali.clinic.rw.service.impl;

import kigali.clinic.rw.domain.Appointment;
import kigali.clinic.rw.repository.AppointmentRepository;
import kigali.clinic.rw.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public String saveAppointment(Appointment appointment) {
    appointmentRepository.save(appointment);
        return "Appointment Saved Successfully";
    }
}
