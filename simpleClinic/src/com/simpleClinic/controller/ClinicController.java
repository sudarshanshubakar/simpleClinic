package com.simpleClinic.controller;

import java.util.Map;

import com.simpleClinic.model.PatientQueue;
import com.simpleClinic.model.factories.PatientFactory;
import com.simpleClinic.model.helpers.PatientDTO;
import com.simpleClinic.model.helpers.PatientHelper;
import com.simpleClinic.model.interfaces.Patient;
import com.simpleClinic.model.interfaces.QueuedPatient;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicController {
	private final PatientHelper _patientHelper = PatientHelper.getInstance();

	public ClinicResponse createPatient(ClinicRequest request) {
		String name = (String) request.getAttribute("name");
		PatientDTO patient = _patientHelper.create(name);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("operationResult" , patient.getId());
		return response;
	}
	
	public ClinicResponse addPatientToQueue(ClinicRequest request) {
		String id = (String) request.getAttribute("id");
		_patientHelper.addPatientToQueue(id);
	
		return null;
	}
	
	public ClinicResponse findPatient(ClinicRequest request) {
		String findBy = (String) request.getAttribute("findBy");
		String criteria = (String) request.getAttribute("criteria");
		String patientId = _patientHelper.find(findBy, criteria).getId();
		
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId", patientId);
		return response;
	}
	
	public ClinicResponse getNextPatient(ClinicRequest request) {
		PatientDTO patient = _patientHelper.getNextPatientFromQueue();
		String id = patient.getId();
		int queuePosition = patient.getQueuePosition();
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId" , id);
		response.setAttribute("patientQueuePosition", queuePosition);
		return response;
	}
	
	public ClinicResponse savePatientVisit(ClinicRequest request) {
		Map<String, String> visitMap = (Map<String, String>) request.getAttribute("visitMap");
		String id = (String) request.getAttribute("patientId");
		
		return null;
	}
	
	public ClinicResponse getPatientVisitHistory() {
		
		return null;
	}
	
	public ClinicResponse getPatientVisitDetails(ClinicRequest request) {
		
		
		return null;
	}
	
}
