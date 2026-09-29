package kigali.clinic.rw.controller;

import kigali.clinic.rw.domain.Patient;
import kigali.clinic.rw.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient){
        String returnedMsg = patientService.savePatient(patient);

        if(returnedMsg.equals("Patient saved successfully")){
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedMsg);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Patient already exists");
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients(){
        List<Patient> listOfAllPatients = patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK).body(listOfAllPatients);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        String msg = patientService.deletePatient(id);
        if (msg.equals("Patient not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with id " + id + " does not exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }
    @PutMapping
    public ResponseEntity<String> updatePatient(@RequestBody Patient patient){
        String returnedMsg = patientService.updatePatient(patient);
        return  ResponseEntity.status(HttpStatus.OK).body("Patient updated successfully");
    }


}
