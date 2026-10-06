package kigali.clinic.rw.service.impl;

import kigali.clinic.rw.domain.Specialization;
import kigali.clinic.rw.repository.SpecializationRepository;
import kigali.clinic.rw.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public String saveSpecialization(Specialization specialization) {
        boolean specializationExists = specializationRepository.existsByName(specialization.getName());
        if(specializationExists){
            return "Specialization Already Exists";
        }
        specializationRepository.save(specialization);
        return "Specialization saved successfully";
    }

    @Override
    public List<Specialization> getSpecializations() {
        List<Specialization> allSpecializations = specializationRepository.findAll();
        return allSpecializations;
    }

    @Override
    public String deleteSpecialization(Long id) {
        Optional<Specialization> specialization = specializationRepository.findById(id);
        if(specialization.isEmpty()){
            return "Specialization not found";
        }else{
            specializationRepository.deleteById(id);
            return "Specialization deleted successfully";
        }

    }

    @Override
    public String updateSpecialization(Specialization specialization) {
        specializationRepository.updateSpecializationById(specialization.getName(), specialization.getId());
        return "Specialization updated successfully";
    }
}
