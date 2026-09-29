package kigali.clinic.rw.controller;

import kigali.clinic.rw.domain.Doctor;
import kigali.clinic.rw.repository.DoctorRepository;
import kigali.clinic.rw.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor){
        String returnedMsg = doctorService.saveDoctor(doctor);

        if(returnedMsg.equals("Doctor saved successfully")){
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedMsg);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Doctor already exists");
        }
    }

    @GetMapping("/doctors")
    public ResponseEntity<?> getAllDoctors(){
        List<Doctor> listOfAllDoctors = doctorService.getDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(listOfAllDoctors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        String msg = doctorService.deleteDoctor(id);
        if (msg.equals("Doctor not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor with id " + id + " does not exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }
    @PutMapping
    public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor){
        String returnedMsg = doctorService.updateDoctor(doctor);
        return  ResponseEntity.status(HttpStatus.OK).body("Doctor updated successfully");
    }


}
