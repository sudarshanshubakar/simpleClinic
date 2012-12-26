package com.simpleClinic.model.factories;

import com.simpleClinic.model.NormalPatient;

public class PatientFactory {
	private static final PatientFactory _instance = new PatientFactory();
	private PatientFactory() {
		
	}

	public static PatientFactory getPatientFactory() {
		return _instance;
	}
	 
	public NormalPatient createPatient(String name)  {

		return null;
	}
	
}
