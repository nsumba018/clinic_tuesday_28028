package kigali.clinic.rw.controller;

import kigali.clinic.rw.domain.Specialization;
import kigali.clinic.rw.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialization")
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSpecialization(@RequestBody Specialization specialization){
        String returnedMsg = specializationService.saveSpecialization(specialization);

        if(returnedMsg.equals("Specialization saved successfully")){
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedMsg);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Specialization already exists");
        }
    }

    @GetMapping("/specializations")
    public ResponseEntity<?> getAllSpecializations(){
        List<Specialization> listOfAllSpecializations = specializationService.getSpecializations();
        return ResponseEntity.status(HttpStatus.OK).body(listOfAllSpecializations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialization(@PathVariable Long id){
        String msg = specializationService.deleteSpecialization(id);
        if (msg.equals("Specialization not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialization with id " + id + " does not exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }
    @PutMapping
    public ResponseEntity<String> updateSpecialization(@RequestBody Specialization specialization){
        String returnedMsg = specializationService.updateSpecialization(specialization);
        return  ResponseEntity.status(HttpStatus.OK).body("Specialization updated successfully");
    }


}
