package com.myproject.techconative.HealthcareAppointmentSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;



@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	
	
	@PostMapping("/api/appointments")
	public ResponseEntity<String> bookAppointmnet(@Valid @RequestBody AppointmentDetails appointmentDetails,PatientDetails patientDetails)
	{   
		boolean mobileNumberExists = appointmentRepository.existsByMobileNumber(appointmentDetails.getMobileNumber());
		boolean patientNameExists = appointmentRepository.existsByPatientName(appointmentDetails.getPatientName());
		AppointmentDetails savedDetails=appointmentRepository.save(appointmentDetails);
		if(mobileNumberExists&&patientNameExists)
		{
		return new ResponseEntity("Appointment Booked Successfully",HttpStatus.CREATED);
		}
		else 
		{
		patientDetails.setPatientName(appointmentDetails.getPatientName());
		patientDetails.setMobileNumber(appointmentDetails.getMobileNumber());
		patientDetails.setPlace(appointmentDetails.getPlace());
		patientRepository.save(patientDetails);
		return new ResponseEntity("Appointment Booked Successfully",HttpStatus.CREATED);
		}
	}
	
	
	
	@GetMapping("/api/appointments")
    public ResponseEntity<AppointmentDetails> retrieveAppointmentsForUser(@RequestParam String patientName)
    {   
		boolean exists = appointmentRepository.existsByPatientName(patientName);
		if(exists)
		{
	    List<AppointmentDetails> details=appointmentRepository.findByPatientName(patientName);
		return new ResponseEntity(details, HttpStatus.OK);
		}
		else 
		return new ResponseEntity("details not found",HttpStatus.NOT_FOUND);
    }
	
	
	 
	
	@DeleteMapping("/api/appointments/{appointmentId}")
	public ResponseEntity<String> cancelAppointment(@PathVariable long appointmentId)
	{   
		boolean exists = appointmentRepository.existsById(appointmentId);
		if(exists)
		{
		 appointmentRepository.deleteById(appointmentId);
		 return new ResponseEntity("Appointment has been cancelled",HttpStatus.OK);
		}
		else 
		return new ResponseEntity("details not found",HttpStatus.NOT_FOUND);
		
	}
	
	
	@PutMapping("/api/appointments/{appointmentId}")
	public ResponseEntity<String> rescheduleAppointment(@PathVariable long appointmentId,@RequestBody AppointmentDetails appointmentDetails)
	{  
		boolean exists = appointmentRepository.existsById(appointmentId);
		if(exists)
		{
		AppointmentDetails updateDateTime=appointmentRepository.findById(appointmentId).orElseThrow();
		updateDateTime.setAppointmentDate(appointmentDetails.getAppointmentDate());
		updateDateTime.setAppointmentTime(appointmentDetails.getAppointmentTime());
		appointmentRepository.save(updateDateTime);
		return new ResponseEntity("Appointment Rescheduled successfully",HttpStatus.OK);
		}
		else
		return new ResponseEntity("details not found",HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/api/patients/{patientId}")
	public ResponseEntity<PatientDetails>accessPatientRecord(@PathVariable long patientId)
	{  
		boolean exists = patientRepository.existsById(patientId);
	    if(exists)
	    {
		Optional<PatientDetails> patientdetails=patientRepository.findById(patientId);
		return new ResponseEntity(patientdetails, HttpStatus.OK);	
	    }
	    else
		return new ResponseEntity("details not found",HttpStatus.NOT_FOUND);
	}
	}

