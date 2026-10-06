package kigali.clinic.rw.repository;

import kigali.clinic.rw.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Transactional
    @Modifying
    @Query("""
            update Patient p set p.firstName = ?1, p.lastName = ?2, p.dateOfBirth = ?3
            where p.id = ?4""")
    int updatePatientById(String firstName, String lastName, Date dateOfBirth, Long id);

    List<Patient> findPatientByLastNameIgnoreCaseByFirstNameAsc(String lastName);

}
