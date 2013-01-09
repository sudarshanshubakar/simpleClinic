package com.simpleClinic.model.helpers;

import java.util.List;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;
import com.simpleClinic.dataTransfer.PatientDTOAssembler;
import com.simpleClinic.dataTransfer.VisitAttributes;
import com.simpleClinic.exceptions.ClinicException;
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
	
	public DTO<PatientAttributes> find(String findBy, String criteria) {
		return DTO.getInstance(PatientAttributes.class);
	}
	
	public DTO<PatientAttributes> create(String name) throws ClinicException {
		Patient patient = PatientFactory.getPatientFactory().createPatient(name);
		DTO<PatientAttributes> patientDTO = PatientDTOAssembler.getInstance().createPatientDTO(patient);
		return patientDTO;
	}
	
	public void addPatientToQueue(String id) {
		PatientQueue.getQueue().addPatient(id);
	}
	
	public DTO<PatientAttributes> getNextPatientFromQueue() {
		DTO<PatientAttributes> patient = PatientQueue.getQueue().getNextPatient();
		return patient;
	}

	public List<DTO<VisitAttributes>> getVisitHistory(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
