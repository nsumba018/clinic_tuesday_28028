package kigali.clinic.rw.service;

import kigali.clinic.rw.domain.Specialization;

import java.util.List;

public interface SpecializationService {
    String saveSpecialization(Specialization specialization);
    List<Specialization> getSpecializations();
    String deleteSpecialization(Long id);
    String updateSpecialization(Specialization specialization);

    List<Specialization> getUnusedSpecializations();
}
