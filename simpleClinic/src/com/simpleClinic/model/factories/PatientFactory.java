package com.simpleClinic.model.factories;

import com.simpleClinic.model.Patient;

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
	
}
