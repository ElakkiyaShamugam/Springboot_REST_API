package com.myproject.techconative.HealthcareAppointmentSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDetails,Long>{

}
