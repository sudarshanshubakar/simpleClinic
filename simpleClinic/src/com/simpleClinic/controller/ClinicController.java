package com.simpleClinic.controller;

import com.simpleClinic.model.PatientQueue;
import com.simpleClinic.model.factories.PatientFactory;
import com.simpleClinic.model.interfaces.Patient;
import com.simpleClinic.model.interfaces.QueuedPatient;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicController {

	public ClinicResponse createPatient(ClinicRequest request) {
		String name = request.getAttribute("name");
		Patient patient = PatientFactory.getPatientFactory().createPatient(name);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("operationResult" , patient.getID());
		return response;
	}
	
	public ClinicResponse addPatientToQueue(ClinicRequest request) {
		String id = request.getAttribute("id");
		PatientQueue.getQueue().addPatient(id);
		return null;
	}
	
	public ClinicResponse findPatient(ClinicRequest request) {
		String findBy = request.getAttribute("findBy");
		String criteria = request.getAttribute("criteria");
		
		
		return null;
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
		
		
		return null;
	}
	
	public ClinicResponse getPatientVisitHistory() {
		
		return null;
	}
	
	public ClinicResponse getPatientVisitDetails(ClinicRequest request) {
		
		
		return null;
	}
	
}
