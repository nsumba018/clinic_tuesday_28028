package kigali.clinic.rw.controller;

import kigali.clinic.rw.domain.Appointment;
import kigali.clinic.rw.domain.AppointmentStatus;
import kigali.clinic.rw.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointeService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAppointment(@RequestBody Appointment appointment) {
        String returnedMsg = appointeService.saveAppointment(appointment);
        if(returnedMsg.equals("Appointment Saved Successfully")) {
            return new ResponseEntity<>("Appointment Saved Successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(returnedMsg, HttpStatus.BAD_REQUEST);
        }
    }

    // A2
    @GetMapping("/by-status")
    public ResponseEntity<?> getAppointmentsByStatus(@RequestParam AppointmentStatus status){
        List<Appointment> appointments = appointeService.getAppointmentsByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }
}
