package com.simpleClinic.model.helpers;

import com.simpleClinic.model.PatientQueue;
import com.simpleClinic.model.factories.PatientFactory;
import com.simpleClinic.model.interfaces.Patient;

public class PatientHelper {

	private static final PatientHelper _instance = new PatientHelper();
	private PatientHelper() {
		
	}
	
	public static final PatientHelper getInstance() {
		return _instance;
	}
	
	public PatientDTO find(String findBy, String criteria) {
		return new PatientDTO(null, null, 0);
	}
	
	public PatientDTO create(String name) {
		Patient patient = PatientFactory.getPatientFactory().createPatient(name);
		return patient.getDTO();
	}
	
	public void addPatientToQueue(String id) {
		PatientQueue.getQueue().addPatient(id);
	}
	
	public PatientDTO getNextPatientFromQueue() {
		PatientDTO patient = PatientQueue.getQueue().getNextPatient();
		return patient;
	}
	
	
}
