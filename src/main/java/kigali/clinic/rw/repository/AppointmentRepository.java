package kigali.clinic.rw.repository;

import kigali.clinic.rw.domain.Appointment;
import kigali.clinic.rw.domain.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // A2 (DERIVED): appointments with that status, earliest date first
    List<Appointment> findByStatusOrderByAppointmentDateAsc(AppointmentStatus status);

}
