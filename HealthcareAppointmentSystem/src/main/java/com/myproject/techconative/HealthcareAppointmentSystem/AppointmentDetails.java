package com.myproject.techconative.HealthcareAppointmentSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class AppointmentDetails{
	@Id
	@GeneratedValue
	private long appointmentId;
	@Size(min=2)
	private String patientName;
	private long mobileNumber;
	@Size(min=2)
	private String place;
	@Size(min=2)
	private String doctorName;
	@FutureOrPresent
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	@Override
	public String toString() {
		return "AppointmentDetails [appointmentId=" + appointmentId + ", patientName=" + patientName + ", mobileNumber="
				+ mobileNumber + ", place=" + place + ", doctorName=" + doctorName + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}
}
