package kigali.clinic.rw.service.impl;

import kigali.clinic.rw.domain.Doctor;
import kigali.clinic.rw.repository.DoctorRepository;
import kigali.clinic.rw.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String saveDoctor(Doctor doctor) {
        boolean doctorExists = doctorRepository.existsByFirstNameAndLastNameAndDateOfBirth(
                doctor.getFirstName(), doctor.getLastName(), doctor.getDateOfBirth());
        if(doctorExists){
            return "Doctor Already Exists";
        }
        doctorRepository.save(doctor);
        return "Doctor saved successfully";
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> allDoctors = doctorRepository.findAll();
        return allDoctors;
    }

    @Override
    @Transactional
    public String deleteDoctor(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isEmpty()){
            return "Doctor not found";
        }else{
            Doctor foundDoctor = doctor.get();
            if(foundDoctor.getOffice() != null){
                foundDoctor.getOffice().setDoctor(null);
                foundDoctor.setOffice(null);
            }
            doctorRepository.delete(foundDoctor);
            return "Doctor deleted successfully";
        }

    }

    @Override
    public String updateDoctor(Doctor doctor) {

        doctorRepository.updateDoctorById(doctor.getFirstName(),doctor.getLastName(),
                doctor.getDateOfBirth(), doctor.getId(), doctor.getOffice());
        return "Doctor updated successfully";
    }
}
