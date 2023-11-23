package com.myproject.techconative.HealthcareAppointmentSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class PatientDetails{
	@Id
	@GeneratedValue
	private long patientId;
	private String patientName;
	private long mobileNumber;
	private String place;
	
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
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
	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patientName=" + patientName + ", mobileNumber="
				+ mobileNumber + ", place=" + place + "]";
	}
	

}
