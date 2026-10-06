package kigali.clinic.rw.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="appointment")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="appointment_date")
    private LocalDate appointmentDate;

    @Column(name="reason")
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
}
