package com.simpleClinic.model.factories;

import java.util.Map;

import com.simpleClinic.model.interfaces.Patient;

public class PatientFactory {
	private static final PatientFactory _instance = new PatientFactory();
	private PatientFactory() {
		
	}

	public static PatientFactory getPatientFactory() {
		return _instance;
	}
	 
	public Patient createPatient(String name)  {

		return null;
	}
	
	public void savePatientDetails(Map<String, String> patientDetails) {
		
	}
	
}
