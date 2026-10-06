package kigali.clinic.rw.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name="office_id")
    private Office office;

    @ManyToMany
    @JoinTable(
       name = "doctor_specialization",
       joinColumns = @JoinColumn(name="doctor_id"),
       inverseJoinColumns = @JoinColumn(name="specialization_id")
    )
    @JsonIgnoreProperties("doctors")
    private List<Specialization> specializations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();
}
