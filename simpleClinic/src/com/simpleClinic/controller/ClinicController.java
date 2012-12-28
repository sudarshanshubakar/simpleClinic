package com.simpleClinic.controller;

import java.util.Map;

import com.simpleClinic.model.PatientQueue;
import com.simpleClinic.model.factories.PatientFactory;
import com.simpleClinic.model.helpers.PatientFinder;
import com.simpleClinic.model.interfaces.Patient;
import com.simpleClinic.model.interfaces.QueuedPatient;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicController {

	public ClinicResponse createPatient(ClinicRequest request) {
		String name = (String) request.getAttribute("name");
		Patient patient = PatientFactory.getPatientFactory().createPatient(name);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("operationResult" , patient.getID());
		return response;
	}
	
	public ClinicResponse addPatientToQueue(ClinicRequest request) {
		String id = (String) request.getAttribute("id");
		PatientQueue.getQueue().addPatient(id);
		return null;
	}
	
	public ClinicResponse findPatient(ClinicRequest request) {
		String findBy = (String) request.getAttribute("findBy");
		String criteria = (String) request.getAttribute("criteria");
		String patientId = PatientFinder.getInstance().find(findBy, criteria).get_id();
		
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId", patientId);
		return response;
	}
	
	public ClinicResponse getNextPatient(ClinicRequest request) {
		Patient patient = PatientQueue.getQueue().getNextPatient();
		String id = patient.getID();
		int queuePosition = ((QueuedPatient)patient).getQueuePosition();
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
