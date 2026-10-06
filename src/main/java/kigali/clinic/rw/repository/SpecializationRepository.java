package kigali.clinic.rw.repository;

import kigali.clinic.rw.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    boolean existsByName(String name);

    @Transactional
    @Modifying
    @Query("""
            update Specialization s set s.name = ?1
            where s.id = ?2""")
    int updateSpecializationById(String name, Long id);

    // B3
    @Query("select s from Specialization s where s.doctors is empty")
    List<Specialization> findUnusedSpecializations();
}
