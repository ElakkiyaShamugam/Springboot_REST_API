package com.myproject.techconative.HealthcareAppointmentSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<AppointmentDetails,Long> {

	List<AppointmentDetails> findByPatientName(String patientName);
	
	boolean existsByPatientName(String patientName);

	boolean existsByMobileNumber(long mobileNumber);

	
}
