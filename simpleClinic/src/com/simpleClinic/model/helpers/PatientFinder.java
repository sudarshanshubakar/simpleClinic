package com.simpleClinic.model.helpers;

public class PatientFinder {

	private static final PatientFinder _instance = new PatientFinder();
	private PatientFinder() {
		
	}
	
	public static final PatientFinder getInstance() {
		return _instance;
	}
	
	public PatientDTO find(String findBy, String criteria) {
		return null;
	}
}
