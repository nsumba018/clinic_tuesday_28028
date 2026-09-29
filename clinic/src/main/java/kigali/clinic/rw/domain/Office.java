package kigali.clinic.rw.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="office")
@Getter
@Setter
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="office_number", unique = true)
    private int officeNumber;

    @OneToOne(mappedBy = "office")
    @JsonIgnore
    private Doctor doctor;
}
