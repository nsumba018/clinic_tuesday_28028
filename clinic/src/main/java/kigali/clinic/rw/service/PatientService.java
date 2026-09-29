package kigali.clinic.rw.service;

import kigali.clinic.rw.domain.Patient;

import java.util.List;

public interface PatientService {
    String savePatient(Patient patient);
    List<Patient> getPatients();
    String deletePatient(Long id);
    String updatePatient(Patient patient);
}
