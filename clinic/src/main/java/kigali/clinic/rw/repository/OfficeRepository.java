package kigali.clinic.rw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kigali.clinic.rw.domain.Doctor;
import kigali.clinic.rw.domain.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Long> {

    List<Office> findByName(String name);
    Optional<Office> findByOfficeNumber(int officeN);

    List<Office> findByOfficeNumberStartsWith(int startNumber);

    List<Office> findByOfficeNumberEndsWith(int endNumber);

    @Transactional
    @Modifying
    @Query("update Office o set o.name = ?1, o.officeNumber = ?2 where o.id = ?3")
    int updateOfficeById(String name, int officeNumber, @NonNull Long id);
}
