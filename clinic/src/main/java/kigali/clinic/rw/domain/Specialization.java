package kigali.clinic.rw.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(
       name = "doctor_specialization",
       joinColumns = @JoinColumn(name="specialization_id"),
       inverseJoinColumns = @JoinColumn(name="doctor_id")
    )
    private List<Doctor> doctors = new ArrayList<>();
}
